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

@WebServlet("/updateOrderStatus")
public class UpdateStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(req.getParameter("orderId"));
            String status = req.getParameter("newStatus");

            HttpSession session = req.getSession();

            OrdersDAO dao = new OrdersDAO(DatabaseConnect.getConn());
            boolean change = dao.changeStatusById(orderId, status);

            if (change) {
                session.setAttribute("successMsg", "Status updated successfully!");
                resp.sendRedirect("view_orders.jsp");
            } else {
                session.setAttribute("successMsg", "Something went wrong. Could not update status");
                resp.sendRedirect("view_orders.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
