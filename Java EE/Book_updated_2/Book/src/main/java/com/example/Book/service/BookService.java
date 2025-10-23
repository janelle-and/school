package com.example.Book.service;

import com.example.Book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAllBooks(String category);
    Optional<Book> findBookById(int id);

    Book saveBook(Book book);
    Book updateBook(int id, Book book);
    void deleteBookById(int id);
}
