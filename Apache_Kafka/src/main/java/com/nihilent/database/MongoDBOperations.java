package com.nihilent.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.nihilent.entity.Customer;

public class MongoDBOperations implements DatabaseOperations {

    DBCollection customerDetails = null;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    public void saveCustomer(Customer customer) {
        getConnection();
        DBObject document = new BasicDBObject();
        document.put("customerId", customer.getCustomerId());
        document.put("status", customer.getStatus());
        document.put("start_time", customer.getStartTime());
        document.put("end_time", customer.getEndTime());
        customerDetails.save(document);
    }

    public List<Customer> getCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        try {
            getConnection();
            DBCursor cursor = customerDetails.find().sort(new BasicDBObject("end_time", -1));
            while (cursor.hasNext()) {
                DBObject document = cursor.next();
                String startTime = (String) document.get("start_time");
                String endTime = (String) document.get("end_time");
                Customer customer = new Customer(
                        Integer.parseInt(document.get("customerId").toString()),
                        (String) document.get("status"), startTime, endTime);
                double timeDifference = ((double) (formatter.parse(endTime).getTime() - formatter.parse(
                        startTime).getTime()) / 1000);
                customer.setTimeDifference(timeDifference);
                list.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while retriving Custoemr Details");

        }
        return list;
    }

    private void getConnection() {
        if (customerDetails == null) {
            Mongo mongo = new Mongo();
            DB db = new DB(mongo, "customer");
            customerDetails = db.getCollection("customer_details");
        }
    }

    public void closeConnections() {
        // Do nothing
    }
}
