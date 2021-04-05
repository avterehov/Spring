package org.example.servlet;

import javax.servlet.*;
import java.io.IOException;

public class FirstServlet implements Servlet {

   private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        getServletConfig().getServletContext().getRequestDispatcher("/page_header").include(request, response);
        response.getWriter().println("<h1> You are inside a servlet</h1>");
        response.getWriter().println("<h2> You are inside a servlet</h2>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
