package com.servlet;

import com.dao.OrdersDAO;
import com.db.DatabaseConnect;
import com.entity.Orders;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/handlePlacedOrder")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int usersid = Integer.parseInt(req.getParameter("usersid"));
            int bookIdO = Integer.parseInt(req.getParameter("bookIdO"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            String paymode = req.getParameter("paymode");

            Orders order = new Orders();
            order.setUid(usersid);
            order.setBid(bookIdO);
            order.setUname(name);
            order.setEmail(email);
            order.setPhone(phone);
            order.setAddress(address);
            order.setPayMethod(paymode);

            HttpSession session = req.getSession();

            OrdersDAO dao = new OrdersDAO(DatabaseConnect.getConn());
            boolean placement = dao.placeOrder(order);

            if(placement){
                session.setAttribute("successMsg", "Congratulations, Order Placed!");
                resp.sendRedirect("home.jsp");
            }else{
                session.setAttribute("successMsg", "Something went wrong. Order could not be placed.");
                resp.sendRedirect("home.jsp");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
