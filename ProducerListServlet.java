package org.example.servlet;

import org.example.ProducerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ProducerListServlet extends HttpServlet {
    private ProducerDAO dao = new ProducerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("producers", dao.getAllProducers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
