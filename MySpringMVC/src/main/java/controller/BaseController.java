package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

@Controller
public class BaseController {

	
	@RequestMapping(value = "/welcome.htm")
	public String welcome () {
		
		System.out.println("@@@@INSIDE WELCOME METHOD@@@@");
		
		System.out.println("\n\n==============Message In==============");
        System.out.println(new String(messageIn));
        System.out.println("======================================\n");

        List<Customer> messageOut = null;
		try {
			messageOut = runSmooksTransform();
		} catch (SmooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("==============Message Out=============");
        for (Customer object : messageOut) {
        	System.out.println(object.getFirstName()+object.getGender());			
		}
        System.out.println(messageOut);
        System.out.println("======================================\n\n");
		
		return "index";
	}
	
	private String messageIn = readInputMessage();

    private List<Customer> runSmooksTransform() throws IOException, SAXException, SmooksException {

        Smooks smooks = new Smooks("smooks-config.xml");

        try {
            ExecutionContext executionContext = smooks.createExecutionContext();
            JavaResult result = new JavaResult();

            // Configure the execution context to generate a report...
            executionContext.setEventListener(new HtmlReportGenerator("target/report/report.html"));

            smooks.filterSource(executionContext, new StringSource(messageIn), result);

            return (List<Customer>) result.getBean("customerList");
        } finally {
            smooks.close();
        }
    }

    private String readInputMessage() {
        try {
            return StreamUtils.readStreamAsString(new FileInputStream(this.getClass().getResource( "/input-message.csv" ).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
            return "<no-message/>";
        }
    }
    
    @RequestMapping("/saveData.htm")
    public String saveData() throws SolrServerException, IOException {
    	System.out.println("Start testSolr");
    	HttpSolrServer server = new HttpSolrServer("http://localhost:8090/solr-example");
        for(int i=0;i<10;++i) {
          SolrInputDocument doc = new SolrInputDocument();
          doc.addField("cat", "book");
          doc.addField("id", "book-" + i);
          doc.addField("name", "The Legend of the Hobbit part " + i);
          server.add(doc);
          if(i%100==0) server.commit();  // periodically flush
        }
        server.commit(); 
    	System.out.println("Finish testSolr");
    	return "index";
    }
    
    @RequestMapping("/searchData.htm")
    public String searchData() throws SolrServerException, IOException {
    	System.out.println("Start searchData");
    	HttpSolrServer solr = new HttpSolrServer("http://localhost:8090/solr-example");

        SolrQuery query = new SolrQuery();
        query.setQuery("book-5");
        query.addFilterQuery("cat:book");
        query.setFields("id", "cat", "name");
        query.setStart(0);
        query.set("defType", "edismax");

        QueryResponse response = solr.query(query);
        SolrDocumentList results = response.getResults();
        for (int i = 0; i < results.size(); ++i) {
          System.out.println(results.get(i));
        }
    	System.out.println("Finish searchData");
    	return "index";
    }
    
    
    @RequestMapping(value = "/testAjax.htm", method=RequestMethod.POST)
    public String testAjax(@RequestBody UserDetails userDetails){
    	System.out.println("Start testAjax");
    	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+userDetails.getAddressDetails().getStreet());
    	System.out.println("Finish testAjax");
    	return "index";
    }
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public String adminPage() {
    	System.out.println("Inside adminPage method");
		return "index";
 
	}
}
