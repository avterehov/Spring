package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/first_http_servlet")
public class FirstHttpServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //  resp.setContentType("text/html");
       //resp.setCharacterEncoding("UTF-8");

        getServletContext().getRequestDispatcher("/page_header").include(req, resp);

        resp.getWriter().println("<h1>Вы находитесь внутри Http-сервлета</h1>");
        resp.getWriter().println("<h2> You are inside a servlet</h2>");

        resp.getWriter().println("<p>contexPath: " + req.getContextPath() + "</p>");
        resp.getWriter().println(("<p>servletPath: " + req.getServletPath() +"</p>"));
        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");

        resp.getWriter().print("<p>param1: " + req.getParameter("name") + "</p>");
        resp.getWriter().print("<p>param2: " + req.getParameter("surname") + "</p>");
        resp.getWriter().print("<p>param3 " + req.getParameter("age")+ "</p>");



    }
}
