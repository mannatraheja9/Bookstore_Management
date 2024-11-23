package com.servlet;

import com.dao.BooksDAO;
import com.dao.CartDAO;
import com.db.DatabaseConnect;
import com.entity.Books;
import com.entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int bid = Integer.parseInt(req.getParameter("bid"));
            int uid = Integer.parseInt(req.getParameter("uid"));

            BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
            Books book = dao.getBookById(bid);

            Cart c = new Cart();
            c.setBid(bid);
            c.setUserid(uid);
            c.setBookName(book.getTitle());
            c.setAuthor(book.getAuthor());
            c.setPrice(book.getPrice());
            c.setTotalPrice(book.getPrice());

            CartDAO dao2 = new CartDAO(DatabaseConnect.getConn());
            boolean addition = dao2.addCart(c);

            HttpSession session = req.getSession();

            if(addition){
                session.setAttribute("successMsg", "Book added to cart!");
                resp.sendRedirect("home.jsp");
            }else{
                session.setAttribute("successMsg", "Could not add book to cart.");
                resp.sendRedirect("home.jsp");

            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
