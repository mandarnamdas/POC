package com.nihilent.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.nihilent.model.Customer;
import com.nihilent.service.CustomerService;

@Controller
@RequestMapping(value = "VIEW")
public class CustomerController {

    Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService custmerService;

    @RenderMapping
    public String viewHomePage(RenderRequest request, RenderResponse response) {

        logger.info("Inside viewHomePage method");
        return "view";
    }

    @RenderMapping(params = "action=showForm")
    public String viewByParameter(Map<String, Object> map) {

        logger.info("Inside viewByParameter method");
        Customer customer = new Customer();
        /**
         * Keep the object customer in the map this object will be used in the JSP as modelAttribute
         */
        map.put("customer", customer);
        /**
         * Returning a String "form" This means that form.jsp is the view
         */
        return "form";
    }

    // For insert the customer details in DB
    @ActionMapping
    public void saveCustomer(@ModelAttribute("customer") Customer customer,
                             ActionRequest actionRequest,
                             ActionResponse actionResponse,
                             Model model) {

        logger.info("Start saveCustomer");
        custmerService.saveCustomer(customer);
        PortletSession portletSession = actionRequest.getPortletSession();
        portletSession.setAttribute("userName", customer.getName());
        actionResponse.setRenderParameter("action", "success");
        logger.info("Finish saveCustomer");
    }

    @RenderMapping(params = "action=success")
    public ModelAndView viewSuccess() {

        List<Customer> custList = new ArrayList<Customer>();
        /**
         * Display success.jsp
         */
        custList = custmerService.getCustomerDetails();
        ModelAndView modelAndView = new ModelAndView("success", "customerList", custList);
        return modelAndView;
    }
}
