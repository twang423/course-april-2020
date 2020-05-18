package com.company;

import java.util.ArrayList;
import java.util.List;

public class StaticPractice {
    public static void main(String[] args) {
        BookSeller.sellBooks();
        BookDatabase.printBooks();
    }
}

class Book {
    private String id;
    private String isbn;
    private String name;
    private String author;
    private String publishDate;

    Book (String id, String isbn, String name, String author, String publishDate) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}

class BookDatabase {
    public static List<Book> books;
    static {
        books = new ArrayList<>();
        books.add(new Book("00769", "98148593", "Java", "Bill", "03-03-2020"));
    }

    public static void printBooks() {
        for (Book b:books) {
            System.out.println(b);
        }
    }
}
class BookSeller {

    static void sellBooks () {
        BookDatabase.books.add(new com.company.Book("05717", "9816753", "C++", "Amy", "03-08-2020"));
    }

    static class Book {
        private String id;
        private String isbn;
        private String name;
        private String author;
        private String publishDate;
    }
}
