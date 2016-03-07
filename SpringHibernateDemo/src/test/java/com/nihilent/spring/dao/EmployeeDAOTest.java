package com.nihilent.spring.dao;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nihilent.spring.configuration.HibernateTestConfiguration;
import com.nihilent.spring.entity.Employee;

@ContextConfiguration(classes = {
    HibernateTestConfiguration.class
})
public class EmployeeDAOTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeDAO employeeDao;

    @BeforeMethod
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    public IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream(
                "Employee.xml"));
        return dataSet;
    }

    @Test
    public void findById() {
        Employee emp = employeeDao.find(1);
        System.out.println(emp.getName());
        Assert.assertNotNull(employeeDao.find(1));
        Assert.assertNull(employeeDao.find(3));
    }
}
