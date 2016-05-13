package com.nihilent.service;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.spring.SpringContextLoaderSupport;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

public class MyContextLoaderListener extends ContextLoaderListener {

    private final SpringContextLoaderSupport springContextLoaderSupport = new SpringContextLoaderSupport();

    @Override
    protected void customizeContext(ServletContext servletContext,
                                    ConfigurableWebApplicationContext configurableWebApplicationContext) {

        super.customizeContext(servletContext, configurableWebApplicationContext);
        this.springContextLoaderSupport.customizeContext(
                servletContext, configurableWebApplicationContext);
    }
}
