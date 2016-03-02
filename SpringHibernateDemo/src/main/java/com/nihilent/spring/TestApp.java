package com.nihilent.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nihilent.spring.configuration.AppConfig;
import com.nihilent.spring.entity.Employee;
import com.nihilent.spring.service.EmployeeService;

public class TestApp {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Mandar");

        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Namdas");

        /*
         * Persist both Employees
         */
        employeeService.createEmployee(employee1);
        employeeService.createEmployee(employee2);

        context.close();
    }

}
