package com.library;

import java.util.UUID;

public class Book {
    private UUID bookID;
    private String title;
    private String author;
    private String isbn;
    private boolean checkedOut;

    public Book(String title, String author, String isbn) {
        this.bookID = UUID.randomUUID(); // Generates a random UUID
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.checkedOut = false;
    }

    // Getter and setter methods for other fields
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    // Getter method for bookID
    public UUID getBookID() {
        return bookID;
    }

    public void checkOut() {
        if (!isCheckedOut()) {
            setCheckedOut(true);
            System.out.println("Book checked out: " + getTitle());
        } else {
            System.out.println("Book is already checked out: " + getTitle());
        }
    }

    public void returnBook() {
        if (isCheckedOut()) {
            setCheckedOut(false);
            System.out.println("Book returned: " + getTitle());
        } else {
            System.out.println("Book is not checked out: " + getTitle());
        }
    }

    @Override
    public String toString() {
        return "Book ID: " + bookID.toString() + ", Title: " + title + ", Author: " + author + ", ISBN: " + isbn
                + ", Checked Out: " + checkedOut;
    }
}
