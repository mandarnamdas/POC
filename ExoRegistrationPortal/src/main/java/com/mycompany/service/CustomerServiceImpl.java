package com.mycompany.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.CustomerDao;
import com.mycompany.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public void saveCustomer(Customer customer) {
        logger.info("Inside saveCustomer");
        customerDao.save(customer);

    }

    public List<Customer> getCustomerDetails() {
        logger.info("Inside getCustomerDetails");
        return customerDao.get();
    }
}
