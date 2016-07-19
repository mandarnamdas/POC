package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Customer;

public interface CustomerService {

    public void saveCustomer(Customer customer);

    public List<Customer> getCustomerDetails();

}
