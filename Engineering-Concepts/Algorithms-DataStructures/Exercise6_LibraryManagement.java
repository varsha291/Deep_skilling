import java.util.Arrays;
import java.util.Comparator;

public class Exercise6_LibraryManagement {
    static class Book {
        int bookId;
        String title;
        String author;

        Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return bookId + " - " + title + " by " + author;
        }
    }

    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return sortedBooks[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Clean Code", "Robert C. Martin"),
                new Book(2, "Data Structures", "Seymour Lipschutz"),
                new Book(3, "Java Programming", "Herbert Schildt"),
                new Book(4, "Algorithms", "Robert Sedgewick")
        };

        System.out.println("Linear search: " + linearSearchByTitle(books, "Algorithms"));

        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, Comparator.comparing(book -> book.title.toLowerCase()));
        System.out.println("Binary search: " + binarySearchByTitle(sortedBooks, "Algorithms"));

        System.out.println("\nComplexity:");
        System.out.println("Linear search is O(n). Binary search is O(log n), but only works after sorting.");
    }
}
