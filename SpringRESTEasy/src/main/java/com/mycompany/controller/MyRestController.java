package com.mycompany.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.service.MyService;

@Component
@Path("/mycontroller")
public class MyRestController {

    @Autowired
    MyService service;

    @GET
    @Path("/handle")
    public void handleRequest() {
        System.out.println("Inside My Rest Controller");
        service.process();
    }

}
