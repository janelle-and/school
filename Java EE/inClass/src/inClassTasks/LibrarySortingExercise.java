package inClassTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibrarySortingExercise {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("Spring Boot Guide", "Charlie", 2021, 2000));
        library.add(new Book("Java Basics", "Alice", 2019, 5000));
        library.add(new Book("Data Structures", "Bob", 2018, 3000));
        library.add(new Book("Python Fundamentals", "David", 2020, 1500));
        // TODO: Task 1 - Sort by yearPublished (Comparable)
        System.out.println("Sorted by year published");
        Collections.sort(library);
        for (Book book : library) {
            System.out.println(book);
        }

        // TODO: Task 2 - Sort by title (Comparator anonymous class / lambda)
        System.out.println("\nSorted by title");
        library.sort(Comparator.comparing(Book::getTitle));
        for (Book book : library) {
            System.out.println(book);
        }

        // using lambda
        library.sort((b1, b2) -> b1.title.compareTo(b2.title));
        System.out.println("\nSorted by Title (Lambda)");
        library.forEach(System.out::println);

        // TODO: Task 3 - Sort by copiesSold descending (Comparator helper)
        System.out.println("\nSorted by copies sold in descending order");
        library.sort(Comparator.comparing(Book::getCopiesSold).reversed());
        for (Book book : library) {
            System.out.println(book);
        }

        // TODO: Task 4 - Sort by author then title (Comparator chaining)
        System.out.println("\nSorted by author then title");
        library.sort(Comparator.comparing(Book::getAuthor)
                .thenComparing(Book::getTitle));
        for (Book book : library) {
            System.out.println(book);
        }

        // TODO: Task 5 (Bonus) - Multi-criteria sorting
        System.out.println("\nSort by yearPublished ascending, then by copiesSold descending, then by title");
        library.sort(Comparator.comparingInt(Book::getYearPublished)
                .thenComparing(Comparator.comparingInt(Book::getCopiesSold).reversed())
                .thenComparing(Book::getTitle));
        for (Book book : library) {
            System.out.println(book);
        }
    }
}

class Book implements Comparable<Book> {
    String title;
    String author;
    int yearPublished;
    int copiesSold;

    Book(String title, String author, int yearPublished, int copiesSold) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + yearPublished +
                ", sold=" + copiesSold +
                '}';
    }
    // TODO: Task 1 - Implement Comparable

    @Override
    public int compareTo(Book o) {
        return this.yearPublished - o.yearPublished;
    }
}

