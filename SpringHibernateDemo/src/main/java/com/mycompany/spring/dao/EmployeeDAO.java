package com.mycompany.spring.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.spring.common.dao.GenericDAOImpl;
import com.mycompany.spring.entity.Employee;

@Repository("employeeDAO")
public class EmployeeDAO extends GenericDAOImpl<Employee, Long> {

}
