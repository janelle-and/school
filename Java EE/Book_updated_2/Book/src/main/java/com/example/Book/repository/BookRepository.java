package com.example.Book.repository;

import com.example.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<Book> findByTitleIgnoreCase(String title);


}
