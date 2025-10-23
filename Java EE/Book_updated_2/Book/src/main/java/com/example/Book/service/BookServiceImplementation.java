package com.example.Book.service;

import com.example.Book.model.Book;
import com.example.Book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks(String category) {
        List<Book> books = bookRepository.findAll();
         if(category != null){
             return books.stream()
                     .filter(book->book.getCategory().equalsIgnoreCase(category))
                     .collect(Collectors.toList());
         }
         return books;
    }

    @Override
    public Optional<Book> findBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                            existingBook.setCategory(book.getCategory());
                            existingBook.setAuthor(book.getAuthor());
                            existingBook.setTitle(book.getTitle());

                            return bookRepository.save(existingBook);
                        }
                )
                .orElse(null);
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}
