package com.mycompany.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.model.Customer;

public class MySqlDatabaseOperations {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.16.20.151:3306/testschema";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn = null;
    Statement stmt = null;

    public void saveCustomer(Customer customer) {
        try {
            getConnection();
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("INSERT into customer_record values (");
            sql.append(customer.getId());
            sql.append(",'");
            sql.append(customer.getName());
            sql.append("','");
            sql.append(customer.getEmail());
            sql.append("','");
            sql.append(customer.getUsername());
            sql.append("','");
            sql.append(customer.getPassword());
            sql.append("')");
            stmt.executeUpdate(sql.toString());
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Exception occurred while saving Custoemr Details");

        }
    }

    public List<Customer> getCustomers() {
        List<Customer> customerDetails = new ArrayList<Customer>();
        try {
            getConnection();
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("SELECT * from customer_record");
            ResultSet rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");

                Customer customer = new Customer(id, name, email, username);

                customerDetails.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while retriving Customer Details" + e);

        }
        return customerDetails;
    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        if (conn == null) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
    }

    public void closeConnections() {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
        }
    }

}
