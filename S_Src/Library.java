import java.util.ArrayList;
import java.util.Scanner;

class Library {
    // A class to represent a Book
    static class Book {
        String title;
        String author;
        boolean isAvailable;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
        }
    }

    // A list to store books in the library
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    // Method to display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    // Method to lend a book
    public void lendBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isAvailable) {
                book.isAvailable = false;
                System.out.println("You have successfully borrowed: " + title);
                return;
            }
        }
        System.out.println("Sorry, the book is not available or does not exist.");
    }

    // Method to return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isAvailable) {
                book.isAvailable = true;
                System.out.println("You have successfully returned: " + title);
                return;
            }
        }
        System.out.println("Sorry, the book is not found in the system.");
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String title, author;
        int choice;

        do {
            System.out.println("\n=== School Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Lend Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    title = scanner.nextLine();
                    library.lendBook(title);
                    break;
                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 5:
                    System.out.println("Exiting the library system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}