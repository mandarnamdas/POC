package com.mycompany.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.spring.dao.EmployeeDAO;
import com.mycompany.spring.entity.Employee;

@Transactional
@Service("employeeService")
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public void createEmployee(Employee e) {
        employeeDAO.save(e);
    }
}
