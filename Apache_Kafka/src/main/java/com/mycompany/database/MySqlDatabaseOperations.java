package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.entity.Customer;

public class MySqlDatabaseOperations implements DatabaseOperations {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://172.16.250.220:3306/CUSTOMER";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    Connection conn = null;
    Statement stmt = null;

    public void saveCustomer(Customer customer) {
        try {
            getConnection();
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer("INSERT into customer_details values (");
            sql.append(customer.getCustomerId());
            sql.append(",'");
            sql.append(customer.getStatus());
            sql.append("','");
            sql.append(customer.getStartTime());
            sql.append("','");
            sql.append(customer.getEndTime());
            sql.append("')");
            stmt.executeUpdate(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while saving Custoemr Details");

        }
    }

    public List<Customer> getCustomers() {
        List<Customer> customerDetails = new ArrayList<Customer>();
        try {
            getConnection();
            stmt = conn.createStatement();
            StringBuffer sql = new StringBuffer(
                    "SELECT * from customer_details order by end_time desc");
            ResultSet rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String status = rs.getString("status");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                double timeDifference = ((double) (formatter.parse(endTime).getTime() - formatter.parse(
                        startTime).getTime()) / 1000);
                Customer customer = new Customer(id, status, startTime, endTime);
                customer.setTimeDifference(timeDifference);
                customerDetails.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while retriving Custoemr Details");

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
