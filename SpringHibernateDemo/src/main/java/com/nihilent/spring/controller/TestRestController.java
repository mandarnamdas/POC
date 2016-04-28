package com.nihilent.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.spring.entity.Employee;
import com.nihilent.spring.service.EmployeeService;

@RestController
public class TestRestController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/testRestController", method = RequestMethod.POST)
    public void saveEmployee() {
        System.out.println("Inside save employee...");
        Employee e = new Employee();
        e.setName("Mandar Namdas");
        employeeService.createEmployee(e);
    }
}
