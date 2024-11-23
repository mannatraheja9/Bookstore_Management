package com.servlet;

import com.dao.BooksDAO;
import com.db.DatabaseConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
            boolean deletion = dao.deleteBook(id);

            HttpSession session = req.getSession();
            if(deletion){
                session.setAttribute("successMsg", "Book deleted successfully!");
                resp.sendRedirect("view_books.jsp");
            }else{
                session.setAttribute("successMsg", "Something went wrong. Book not deleted.");
                resp.sendRedirect("view_books.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
