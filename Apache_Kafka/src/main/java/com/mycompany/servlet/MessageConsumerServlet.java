package com.mycompany.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseEnum;
import com.mycompany.consumer.MessageConsumer;

/**
 * Servlet implementation class MessageConsumerServlet
 */
public class MessageConsumerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final MessageConsumer messageConsumer[] = {
        new MessageConsumer(), new MessageConsumer(), new MessageConsumer(), new MessageConsumer(),
        new MessageConsumer(), new MessageConsumer(), new MessageConsumer(), new MessageConsumer(),
        new MessageConsumer(), new MessageConsumer()
    };

    @Override
    public void init() throws ServletException {
        super.init();

    }

    /**
     * Default constructor.
     */
    public MessageConsumerServlet() {
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
        String option = request.getParameter("option");
        String selectedDB = request.getParameter("database");
        final DatabaseEnum database;
        if (selectedDB != null && !selectedDB.equals("")) {
            database = DatabaseEnum.valueOf(selectedDB);
        } else {
            database = DatabaseEnum.MYSQL;
        }
        request.getSession().setAttribute("database", database);

        if (option.equalsIgnoreCase("start")) {
            Runnable consumer = new Runnable() {

                public void run() {
                    initConsumer(database);
                }
            };
            Thread t = new Thread(consumer);
            t.start();
        } else if (option.equalsIgnoreCase("stop")) {
            System.out.println("Stop Message Consumer");
            for (int i = 0; i < 10; i++) {
                messageConsumer[i].stopConsumer();
            }
        }
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }

    private void initConsumer(DatabaseEnum database) {
        System.out.println("Start Consumer");
        ExecutorService consumerThreads = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            messageConsumer[i].setDatabase(database);
            consumerThreads.execute(messageConsumer[i]);
        }
        consumerThreads.shutdown();
        while (!consumerThreads.isTerminated()) {
        }
    }
}
