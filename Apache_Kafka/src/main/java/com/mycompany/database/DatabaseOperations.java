package com.mycompany.database;

import java.util.List;

import com.mycompany.entity.Customer;

public interface DatabaseOperations {

    void saveCustomer(Customer customer);

    public List<Customer> getCustomers();

    void closeConnections();
}
