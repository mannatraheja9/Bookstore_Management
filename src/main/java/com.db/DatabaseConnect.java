package com.db;

import java.sql.*;

public class DatabaseConnect {

    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?useSSL=false&autoReconnect=true", "root", "root");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
