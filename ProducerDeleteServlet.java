package org.example.servlet;

import org.example.ProducerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ProducerDeleteServlet extends HttpServlet {
    private ProducerDAO dao = new ProducerDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        dao.deleteProducer(id);
        resp.sendRedirect("producers");
    }
}
