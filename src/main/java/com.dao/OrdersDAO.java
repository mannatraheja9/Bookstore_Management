package com.dao;

import com.entity.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
    private Connection conn;

    public OrdersDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean placeOrder(Orders order){
        boolean placement = false;
        try{
            String query = "INSERT INTO orders(bid, uid, uname, email, phone, address, pay_method, status) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, order.getBid());
            ps.setInt(2, order.getUid());
            ps.setString(3, order.getUname());
            ps.setString(4, order.getEmail());
            ps.setString(5, order.getPhone());
            ps.setString(6, order.getAddress());
            ps.setString(7, order.getPayMethod());
            ps.setString(8, "Confirmed");

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected == 1){
                placement = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return placement;
    }

    public List<Orders> getAllOrders(){
        List<Orders> list = new ArrayList<>();
        Orders o;
        try{
            String query = "SELECT * FROM orders";
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                o = new Orders();
                o.setOid(resultSet.getInt(1));
                o.setBid(resultSet.getInt(2));
                o.setUid(resultSet.getInt(3));
                o.setUname(resultSet.getString(4));
                o.setEmail(resultSet.getString(5));
                o.setPhone(resultSet.getString(6));
                o.setAddress(resultSet.getString(7));
                o.setPayMethod(resultSet.getString(8));
                o.setStatus(resultSet.getString(9));

                list.add(o);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean changeStatusById(int orderId, String status){
        boolean change = false;
        try{
            String query = "UPDATE orders SET status= ? WHERE oid= ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, orderId);

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 1){
                change = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return change;
    }

    public boolean deleteOrder(int id){
        boolean deletion = false;
        try{
            String query = "DELETE FROM orders WHERE oid = ?";
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
