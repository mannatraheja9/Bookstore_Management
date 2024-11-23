package com.dao;

import java.sql.*;
import com.entity.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksDAO {
    private Connection conn;

    public BooksDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addBooks(Books book){
        boolean addition = false;

        try{
            String query = "INSERT INTO books(title, author, price, quantity) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getQuantity());

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 1){
                addition = true;
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return addition;
    }

    public List<Books> getAllBooks(){
        List<Books> list = new ArrayList<>();
        Books book;

        try{
            String query = "SELECT * FROM books ORDER BY id DESC";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                book = new Books();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setQuantity(resultSet.getInt(5));
                list.add(book);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Books> getAllBooksForUser(){
        List<Books> list = new ArrayList<>();
        Books book;

        try{
            String query = "SELECT * FROM books WHERE quantity > ? ORDER BY id DESC";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, 0);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                book = new Books();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setQuantity(resultSet.getInt(5));
                list.add(book);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Books getBookById(int id){
        Books book = null;

        try{
            String query = "SELECT * FROM books WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                book = new Books();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPrice(resultSet.getDouble(4));
                book.setQuantity(resultSet.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public boolean updateBook(Books book){
        boolean update = false;

        try{
            String query = "UPDATE books SET title= ?, author= ?, price= ?, quantity= ? WHERE id= ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.setInt(5, book.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 1){
                update = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return update;
    }

    public boolean deleteBook(int id){
        boolean deletion = false;

        try{
            String query = "DELETE FROM books WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                deletion =  true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return deletion;
    }
}
