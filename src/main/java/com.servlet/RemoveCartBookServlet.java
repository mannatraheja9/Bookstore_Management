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

@WebServlet("/remove_book")
public class RemoveCartBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid"));
        int uid = Integer.parseInt(req.getParameter("uid"));
        CartDAO dao = new CartDAO(DatabaseConnect.getConn());
        boolean deletion = dao.deleteCartBook(bid,uid);
        HttpSession session = req.getSession();
        if (deletion) {
            session.setAttribute("successMsg", "Book removed from cart.");
            resp.sendRedirect("view_cart.jsp");
        } else {
            session.setAttribute("successMsg", "Something went wrong. Couldn't remove book from cart.");
            resp.sendRedirect("view_cart.jsp");
        }
    }
}
