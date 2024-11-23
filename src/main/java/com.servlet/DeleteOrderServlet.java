package com.servlet;

import com.dao.OrdersDAO;
import com.db.DatabaseConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int osId = Integer.parseInt(req.getParameter("osId"));
        OrdersDAO dao = new OrdersDAO(DatabaseConnect.getConn());
        boolean deletion = dao.deleteOrder(osId);
        HttpSession session = req.getSession();
        if (deletion) {
            session.setAttribute("successMsg", "Order deleted successfully!");
            resp.sendRedirect("view_orders.jsp");
        } else {
            session.setAttribute("successMsg", "Something went wrong. Couldn't delete order.");
            resp.sendRedirect("view_orders.jsp");
        }
    }
}
