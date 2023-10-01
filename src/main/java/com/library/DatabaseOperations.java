package com.library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM your_table";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String column1 = resultSet.getString("column1");
                    String column2 = resultSet.getString("column2");
                    // Process the retrieved data here
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Don't forget to close the connection when done
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
