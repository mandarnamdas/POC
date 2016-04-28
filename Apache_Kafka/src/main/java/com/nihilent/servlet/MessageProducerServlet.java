package com.nihilent.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nihilent.producer.MessageProducer;

/**
 * Servlet implementation class MessageConsumerServlet
 */
public class MessageProducerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public MessageProducerServlet() {
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
        // reading the user input
        Integer threadCount = Integer.parseInt(request.getParameter("threadCount"));
        Integer messageCount = Integer.parseInt(request.getParameter("messageCount"));
        ExecutorService producerThreads = Executors.newFixedThreadPool(500);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            producerThreads.execute(new MessageProducer(messageCount));
        }

        producerThreads.shutdown();

        while (!producerThreads.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();
        String successMessage = "Finished all producer threads in : " + (endTime - startTime)
                + " milliseconds";
        System.out.println(successMessage);
        request.setAttribute("successMessage", successMessage);
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }

}
