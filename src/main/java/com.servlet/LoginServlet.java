package com.servlet;

import com.dao.UsersDAO;
import com.db.DatabaseConnect;
import com.entity.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String em = req.getParameter("email");
            String ps = req.getParameter("password");
            Users user = new Users();
            HttpSession session = req.getSession();

            if("admin@gmail.com".equals(em) && "admin12".equals(ps)){
                session.setAttribute("userObj", user);
                user.setRole("Admin");
                RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
                rd.include(req, resp);
            }else{
                UsersDAO dao = new UsersDAO(DatabaseConnect.getConn());
                Users u = dao.login(em,ps);
                if(u != null){
                    session.setAttribute("userObj", u);
                    resp.sendRedirect("home.jsp");
                }else{
                    session.setAttribute("successMsg", "Invalid Credentials. Try again");
                    resp.sendRedirect("login.jsp");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
