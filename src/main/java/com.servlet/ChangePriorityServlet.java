package com.servlet;

import com.dao.CartDAO;
import com.db.DatabaseConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/changePriority")
public class ChangePriorityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cartId = Integer.parseInt(req.getParameter("cartId"));
        int newPriority = Integer.parseInt(req.getParameter("newPriority"));

        HttpSession session = req.getSession();

        CartDAO dao = new CartDAO(DatabaseConnect.getConn());
        boolean change = dao.changePriorityById(cartId, newPriority);
        if(change){
            session.setAttribute("successMsg", "Priority updated successfully!");
            resp.sendRedirect("view_cart.jsp");
        }else{
            session.setAttribute("successMsg", "Something went wrong. Could not update priority");
            resp.sendRedirect("view_cart.jsp");
        }
    }
}




