CREATE DATABASE bookstore;
use bookstore;

CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT,
                   name VARCHAR(100) NOT NULL,
                   email VARCHAR(150) NOT NULL UNIQUE,
                   password VARCHAR(30) NOT NULL,
                   role VARCHAR(50) NOT NULL);
                   
CREATE TABLE books(id INT PRIMARY KEY AUTO_INCREMENT,
                   title VARCHAR(255) NOT NULL,
                   author VARCHAR(100) NOT NULL,
                   price DECIMAL(10,2) NOT NULL,
                   quantity INT NOT NULL);
                   
CREATE TABLE cart(cid INT PRIMARY KEY AUTO_INCREMENT,
                  bid INT,
                  uid INT,
                  bookName VARCHAR(255), 
                  author VARCHAR(100),
                  price DECIMAL(10,2),
                  total_price DECIMAL(10,2),
                  priority INT DEFAULT 0
                  );
                  
                  
CREATE TABLE orders(oid INT PRIMARY KEY AUTO_INCREMENT,
                    bid INT,
                    uid INT,
                    uname VARCHAR(100),
                    email VARCHAR(150),
                    phone VARCHAR(10),
                    address VARCHAR(255),
                    pay_method VARCHAR(30),
                    status VARCHAR(20)
                    );

SELECT * FROM books;
SELECT * FROM users;
SELECT * FROM cart;
SELECT * FROM orders;

delete from users where id = 53;

                  

                   