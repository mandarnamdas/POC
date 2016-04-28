package com.nihilent.database;

import java.util.List;

import com.nihilent.entity.Customer;

public interface DatabaseOperations {

    void saveCustomer(Customer customer);

    public List<Customer> getCustomers();

    void closeConnections();
}
