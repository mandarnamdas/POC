package com.mycompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dao.MyDao;
import com.mycompany.entity.Employee;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    MyDao myDao;

    public List<Employee> getEmployees() {
        return myDao.getEmployees();
    }

}
