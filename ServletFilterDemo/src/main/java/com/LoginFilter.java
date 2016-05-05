package com;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        System.out.println("LoginFilter constructor...");
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println("Destroy LoginFilter ...");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // place your code here
        System.out.println("LoginFilter doFilter...");
        // pass the request along the filter chain
        chain.doFilter(request, response);
        // request.getRequestDispatcher("/HelloServlet").forward(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("Init LoginFilter...");
    }
}
