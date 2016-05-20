package com.nihilent.service;

import java.util.List;

import com.nihilent.model.Customer;

public interface CustomerService {

    public void saveCustomer(Customer customer);

    public List<Customer> getCustomerDetails();

}
