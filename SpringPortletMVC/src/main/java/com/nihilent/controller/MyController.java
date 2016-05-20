package com.nihilent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nihilent.entity.Employee;
import com.nihilent.service.MyService;

@Controller
public class MyController {

    @Autowired
    MyService myService;

    @RequestMapping("/home")
    public ModelAndView getEmployee() {
        System.out.println("Inside getEmployee Controller");
        List<Employee> list = myService.getEmployees();
        System.out.println(list.size());
        ModelAndView modelView = new ModelAndView("home");
        return modelView;
    }
}
