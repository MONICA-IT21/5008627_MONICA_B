package DSA_1.Library_Management_System;

import java.util.Arrays;

public class LibraryManagementSystem {
    private Books[] books;

    public LibraryManagementSystem(Books[] books) {
        this.books = books;
    }

    public Books linearSearchByTitle(String title) {
        for (Books book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Books binarySearchByTitle(String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Books[] books = {
            new Books(1, "Moby Dick", "Herman Melville"),
            new Books(2, "War and Peace", "Leo Tolstoy"),
            new Books(3, "The Odyssey", "Homer"),
            new Books(4, "Ulysses", "James Joyce"),
            new Books(5, "Madame Bovary", "Gustave Flaubert"),
            new Books(6, "The Catcher in the Rye", "J.D. Salinger"),
        };

        // Assuming books array is sorted by title for binary search
        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        LibraryManagementSystem system = new LibraryManagementSystem(books);

        System.out.println("Linear Search for '1984':");
        System.out.println(system.linearSearchByTitle("1984"));

        System.out.println("\nBinary Search for '1984':");
        System.out.println(system.binarySearchByTitle("1984"));
    }
}
