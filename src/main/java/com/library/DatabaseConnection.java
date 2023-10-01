package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String username = "root";
        String password = "password";
        String jdbcUrl = "jdbc:mysql://localhost:3306/mylibrary?useUnicode=true&characterEncoding=UTF-8&collationConnection=utf8_bin";
        ;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        // Perform database operations here
        // Don't forget to close the connection when done
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from the database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
