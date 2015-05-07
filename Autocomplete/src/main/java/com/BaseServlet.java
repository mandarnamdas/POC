package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 response.setContentType("application/json");
         try {
                 String term = request.getParameter("term");
                 System.out.println("Data from ajax call " + term);

                 ArrayList<String> list = new ArrayList<String>();
                 list.add("Battery");
                 list.add("LED");
                 list.add("Register");
                 list.add("Capaccitor");
                 list.add("Printer");
                 String searchList = new Gson().toJson(list);
                 Thread.sleep(2000);
                 response.getWriter().write(searchList);
         } catch (Exception e) {
                 System.err.println(e.getMessage());
         }
	}
	
}
