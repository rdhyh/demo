package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // // Checking out and returning books
        // Book foundBook = library.findBookByTitle("The Great Gatsby");
        // if (foundBook != null) {
        // foundBook.checkOut();
        // foundBook.returnBook();
        // }

        mainMenu();

    }

    public static void mainMenu() {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to library!");
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
                Book newBook = new Book(title, author, isbn);
                library.addBook(newBook);
                library.displayAvailableBooks();

                break;
            case 2:

                library.displayAvailableBooks();

                break;

            case 3:

                library.displayCheckedOutBooks();
                break;

            default:

                System.out.println("Error!");

        }

        scanner.close();

    }

}
