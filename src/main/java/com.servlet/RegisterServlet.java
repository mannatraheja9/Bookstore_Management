package com.servlet;

import com.dao.UsersDAO;
import com.entity.Users;
import com.db.DatabaseConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/add_user", "/verify_code"})
public class RegisterServlet extends HttpServlet {
    UsersDAO dao = new UsersDAO(DatabaseConnect.getConn());
    public String code = dao.getRandomNumber();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String uri = req.getRequestURI();

            if (uri.contains("/add_user")) {
                String name = req.getParameter("nm");
                String email = req.getParameter("em");
                String password = req.getParameter("ps");

                Users user = new Users(name, email, password, "User");
                boolean addition = dao.addUser(user);

                HttpSession session = req.getSession();
                if(addition){
                    boolean r =  dao.sendEmail(email,code);
                    System.out.println(r);
                    resp.sendRedirect("verify_registration.jsp");
                }else{
                    session.setAttribute("successMsg", "Something went wrong. Could not register.");
                    resp.sendRedirect("signup.jsp");
                }

            } else if (uri.contains("/verify_code")) {
                String regCode = req.getParameter("regCode");
                HttpSession session = req.getSession();
                if(regCode.equals(code)){
                    session.setAttribute("successMsg", "Registration successful! You can now login with your registered email.");
                    resp.sendRedirect("signup.jsp");
                }else{
                    session.setAttribute("successMsg", "Incorrect code!");
                    resp.sendRedirect("signup.jsp");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
