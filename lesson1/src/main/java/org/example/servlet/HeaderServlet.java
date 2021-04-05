package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page_header")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");




        resp.getWriter().println("<ul>");
        resp.getWriter().println("<ls><a href='" + req.getContextPath() + "/first_http_servlet'>HTTP-SERVLET</a></ls>");
        resp.getWriter().println("<ls><a href='" + req.getContextPath() + "/first_servlet'>SERVLET</a></ls>");
        resp.getWriter().println("<ls><a href='#home'>HOME</a></ls>");
        resp.getWriter().println("<ls><a href='#about'>ABOUT</a></ls>");
        resp.getWriter().println("</ul>");

    }
}
