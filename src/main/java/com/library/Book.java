package com.library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean checkedOut;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.checkedOut = false;
    }

    public Book() {
    }

    // Getter and setter methods
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
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Checked Out: " + checkedOut;
    }
}
