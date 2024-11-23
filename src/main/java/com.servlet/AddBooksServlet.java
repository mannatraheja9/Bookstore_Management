package com.servlet;

import com.dao.BooksDAO;
import com.db.DatabaseConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.entity.Books;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add_books")
public class AddBooksServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            double price = Double.valueOf(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            Books book = new Books();
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            book.setQuantity(quantity);

            HttpSession session = req.getSession();

            BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
            boolean addition = dao.addBooks(book);
            if(addition){
                session.setAttribute("successMsg", "Book added successfully!");
                resp.sendRedirect("add_books.jsp");
            }else{
                session.setAttribute("successMsg", "Something went wrong. Book not added.");
                resp.sendRedirect("add_books.jsp");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
