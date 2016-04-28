package com.nihilent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseEnum;
import com.nihilent.database.DatabaseOperations;
import com.nihilent.database.MongoDBOperations;
import com.nihilent.database.MySqlDatabaseOperations;
import com.nihilent.database.SqlDatabaseOperations;
import com.nihilent.entity.Customer;

/**
 * Servlet implementation class MessageConsumerServlet
 */
public class MessageReaderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public MessageReaderServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In Get");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In Post");
        DatabaseEnum database = (DatabaseEnum) request.getSession().getAttribute("database");
        database = database == null ? DatabaseEnum.MYSQL : database;
        DatabaseOperations operations = null;
        if (database == DatabaseEnum.MYSQL) {
            operations = new MySqlDatabaseOperations();
        } else if (database == DatabaseEnum.MONGODB) {
            operations = new MongoDBOperations();
        } else if (database == DatabaseEnum.SQL) {
            operations = new SqlDatabaseOperations();
        }
        List<Customer> customerDetails = operations.getCustomers();
        request.setAttribute("customerDetails", customerDetails);
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
