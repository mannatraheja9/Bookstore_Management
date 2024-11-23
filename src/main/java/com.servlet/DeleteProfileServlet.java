package com.servlet;

import com.dao.UsersDAO;
import com.db.DatabaseConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            UsersDAO dao = new UsersDAO(DatabaseConnect.getConn());
            boolean deletion = dao.deleteUser(id);

            HttpSession session = req.getSession();
            if (deletion) {
                session.setAttribute("successMsg", "Profile deleted successfully!");
                session.removeAttribute("userObj");
                resp.sendRedirect("login.jsp");
            } else {
                session.setAttribute("successMsg", "Something went wrong. Profile not deleted.");
                resp.sendRedirect("home.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}