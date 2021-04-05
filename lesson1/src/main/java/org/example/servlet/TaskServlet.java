package org.example.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet ("/task")
public class TaskServlet extends HttpServlet {

    private List<Product> list;
    String product;
    String price;
    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
        product = null;
        price = null;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        resp.getWriter().println("<h3> Форма для заполнения </h3>");
        resp.getWriter().println("<form method = 'post'>");

        resp.getWriter().println("Введите название продукта <input type = 'text' name = 'productName'>");
       resp.getWriter().println("Введите цену <input type = 'number' name = 'price'>");

        resp.getWriter().println("<input type = 'submit'>");
        resp.getWriter().println("</form>");


        product = req.getParameter("productName");
        price = req.getParameter("price");
        if (product != null && price != null) {
            list.add(new Product(list.size() + 1, product, price));
        }
        for (Product s : list){
            if (s != null ){
                resp.getWriter().println("<p>" + s.getId() + "\t" + s.getProductName() + "\t"+  s.getPrice() + "</p>");
            }
        }

           }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
