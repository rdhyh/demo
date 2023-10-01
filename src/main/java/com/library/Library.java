package com.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        // Insert the book into the database
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            try {
                String insertQuery = "INSERT INTO book (bookID, bookName, bookAuthor, bookISBN) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                preparedStatement.setObject(1, book.getBookID().toString()); // Set the bookID
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setString(3, book.getAuthor());
                preparedStatement.setString(4, book.getIsbn());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Book added to the library and database.");
                } else {
                    System.out.println("Failed to add the book to the database.");
                }

                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Add the book to the list (if needed for in-memory management)
        books.add(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }
}
