package com.mycompany.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.service.ShapeOperationService;

/**
 * Servlet implementation class TestGenericDAOServlet
 */
public class TestGenericDAOServlet extends HttpServlet {

    @EJB
    ShapeOperationService shapeOperationService;

    private static final long serialVersionUID = 1L;

    Logger logger = LoggerFactory.getLogger(TestGenericDAOServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestGenericDAOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Request Received...");
        shapeOperationService.createShape();
    }

}
