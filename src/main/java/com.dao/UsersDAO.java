package com.dao;

import com.entity.Users;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

public class UsersDAO {
    private Connection conn;

    public UsersDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addUser(Users user){
        boolean addition = false;
        try{
            String query = "INSERT INTO users(name, email, password, role) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, "User");

            int rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 1){
                addition = true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return addition;
    }

    public Users login(String em, String psw){
        Users user = null;
        try{
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, em);
            preparedStatement.setString(2, psw);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                user = new Users();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setRole(rs.getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateUser(Users u){
        boolean update = false;
        try{
            String query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getEmail());
            preparedStatement.setString(3, u.getPassword());
            preparedStatement.setInt(4, u.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                update = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

    public boolean deleteUser(int id){
        boolean deletion = false;
        try{
            String query = "DELETE FROM users WHERE id = ?";
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

    public String getRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(9999);
        return String.format("%04d", number);
    }

    public boolean sendEmail(String email,String code){
        boolean test = false;
        try{
        String toEmail = email;
        String fromEmail = "mitalir@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, "nrem jdfo nerr sfeg");
                }
            });
            session.setDebug(true);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("User Email Verification");
            message.setText("Please verify your email using this code:" + code);

            Transport.send(message);
            test = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }
}
