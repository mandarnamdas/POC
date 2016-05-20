package com.nihilent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.dao.MyDao;
import com.nihilent.entity.Employee;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    MyDao myDao;

    public List<Employee> getEmployees() {
        return myDao.getEmployees();
    }

}
