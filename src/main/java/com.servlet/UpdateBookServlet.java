package com.servlet;

import com.dao.BooksDAO;
import com.db.DatabaseConnect;
import com.entity.Books;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String author = req.getParameter("author");
            double price = Double.valueOf(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            Books book = new Books();
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            book.setQuantity(quantity);

            HttpSession session = req.getSession();

            BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
            boolean addition = dao.updateBook(book);
            if (addition) {
                session.setAttribute("successMsg", "Book updated successfully!");
                resp.sendRedirect("view_books.jsp");
            } else {
                session.setAttribute("successMsg", "Something went wrong. Book not updated.");
                resp.sendRedirect("view_books.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
