package com.dao;

import com.entity.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    private Connection conn;

    public CartDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addCart(Cart c){
        boolean addition = false;
        try{
            String query = "INSERT INTO cart(bid, uid, bookName, author, price, total_price) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, c.getBid());
            preparedStatement.setInt(2, c.getUserid());
            preparedStatement.setString(3, c.getBookName());
            preparedStatement.setString(4, c.getAuthor());
            preparedStatement.setDouble(5, c.getPrice());
            preparedStatement.setDouble(6, c.getTotalPrice());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                addition = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return addition;
    }

    public List<Cart> getBooksByUser(int userId){
        List<Cart> list = new ArrayList<>();
        Cart c;
        double totalPrice = 0;
        try{
            String query = "SELECT * FROM cart WHERE uid = ? ORDER BY priority ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                c = new Cart();
                c.setCid(resultSet.getInt(1));
                c.setBid(resultSet.getInt(2));
                c.setUserid(resultSet.getInt(3));
                c.setBookName(resultSet.getString(4));
                c.setAuthor(resultSet.getString(5));
                c.setPrice(resultSet.getDouble(6));

                totalPrice = totalPrice + resultSet.getDouble(7);
                c.setTotalPrice(totalPrice);
                c.setPriority(resultSet.getInt(8));
                list.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean changePriorityById(int cartId, int priority){
        boolean change = false;
        try{
            String query = "UPDATE cart SET priority= ? WHERE cid= ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, priority);
            preparedStatement.setInt(2, cartId);

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 1){
                change = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return change;
    }

    public boolean deleteCartBook(int bid, int uid){
        boolean deletion = false;
        try{
            String query = "DELETE from cart WHERE bid= ? AND uid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, bid);
            preparedStatement.setInt(2, uid);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                deletion = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return deletion;
    }

}
