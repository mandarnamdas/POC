package com.nihilent.spring.dao;

import org.springframework.stereotype.Repository;

import com.nihilent.spring.common.dao.GenericDAOImpl;
import com.nihilent.spring.entity.Employee;

@Repository("employeeDAO")
public class EmployeeDAO extends GenericDAOImpl<Employee, Long> {

}
