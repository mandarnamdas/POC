package com.mycompany.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.entity.Employee;

@Repository
public class MyDaoImpl extends CustomHibernateDaoSupport implements MyDao {

    public List<Employee> getEmployees() {
        return getHibernateTemplate().loadAll(Employee.class);
    }

}
