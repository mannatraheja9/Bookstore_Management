package com.servlet;

import com.dao.UsersDAO;
import com.db.DatabaseConnect;
import com.entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            UsersDAO dao = new UsersDAO(DatabaseConnect.getConn());
            Users u = new Users();
            u.setId(id);
            u.setName(name);
            u.setEmail(email);
            u.setPassword(password);

            boolean update = dao.updateUser(u);
            HttpSession session = req.getSession();
            if(update){
                session.setAttribute("successMsg", "Profile updated successfully!");
                resp.sendRedirect("home.jsp");
            }else{
                session.setAttribute("successMsg", "Something went wrong. Profile not updated.");
                resp.sendRedirect("home.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
