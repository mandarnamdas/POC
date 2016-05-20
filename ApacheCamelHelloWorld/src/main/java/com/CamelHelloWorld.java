package com;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelHelloWorld {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {
            // context.addComponent(
            // "activemq",
            // ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
            context.addRoutes(new RouteBuilder() {

                @Override
                public void configure() throws Exception {
                    // from("direct:in").to("stream:file?fileName=D://mandar.txt");
                    from("direct:in").to("stream:out");
                }
            });
            ProducerTemplate template = context.createProducerTemplate();
            context.start();
            template.sendBody("direct:in", "Hi Mandar");
        } finally {
            context.stop();
        }
    }
}
