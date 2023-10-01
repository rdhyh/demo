package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the library!");
        System.out.println("Choose below :");
        System.out.println("1. Add Book ");
        System.out.println("2. Display Available Books ");
        System.out.println("3. Display Checked out Books ");
        Integer instruct = scanner.nextInt();
        scanner.nextLine();

        switch (instruct) {
            case 1:
                System.out.println("Enter the book title");
                String title = scanner.nextLine();
                System.out.println("Enter the book author");
                String author = scanner.nextLine();
                System.out.println("Enter the book isbn");
                String isbn = scanner.nextLine();

                // Create a new book object
                Book newBook = new Book(title, author, isbn);

                // Add the book to the library
                library.addBook(newBook);
                System.out.println("Book added successfully.");
                break;

            case 2:
                // Display available books
                library.displayAvailableBooks();
                break;

            case 3:
                // Display checked out books
                library.displayCheckedOutBooks();
                break;

            default:
                System.out.println("Error! Invalid choice.");
        }

        scanner.close();
    }
}
