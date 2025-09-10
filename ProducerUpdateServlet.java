package org.example.servlet;

import org.example.ProducerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ProducerUpdateServlet extends HttpServlet {
    private ProducerDAO dao = new ProducerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("producerId", id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateProducer.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String website = req.getParameter("website");

        dao.updateProducer(id, name, country, website);
        resp.sendRedirect("producers");
    }
}
