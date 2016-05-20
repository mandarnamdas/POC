package com.nihilent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nihilent.entity.Employee;

@Repository
public class MyDaoImpl extends CustomHibernateDaoSupport implements MyDao {

    public List<Employee> getEmployees() {
        return getHibernateTemplate().loadAll(Employee.class);
    }

}
