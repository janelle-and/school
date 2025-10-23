package com.example.Book.controller;

import com.example.Book.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import com.example.Book.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//make sure model and controller files are in com.... file not java


@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Book createBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    // http:localhost:8080/books
    // http:localhost:8080/books/category=science
    @GetMapping
    public List<Book> getBookByCategory(@RequestParam(required = false) String category) {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .filter(book -> category == null || book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // localhost:8080/api/books/{id}
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookRepository.findById(id).get();
    }


    // before we added external database
//    private final List<Book> books = new ArrayList<>();
//
//    @PostConstruct
//    public void initializeBooks() {
//        books.addAll(List.of(
//                new Book(1,"Title One","Author One","science"),
//                new Book(2,"Title Two", "Author Two", "science"),
//                new Book(3,"Title Three", "Author Three", "history"),
//                new Book(4,"Title Four", "Author Four", "math"),
//                new Book(5,"Title Five", "Author Five", "math"),
//                new Book(6,"Title Six","Author Six","math")
//        ));
//    }
//
////    @GetMapping("/books")
////    public List<Book> getAllBooks(){
////        return books;
////    }
//
//    // getting book by id
//    @GetMapping("/books/{id}")
//    public Book getBookByTitle(@PathVariable int id){
//        for(Book book : books){
//            if(book.getId() == id) {
//                return book;
//            }
//        }
//        return null;
//    }
//    // sorting by category or all books if no category is selected
////    http://localhost:8080/books?category=math
//    @GetMapping("/books")
//    public List<Book> getBooksByCategory(@RequestParam(required=false) String category){
//        if (category == null){
//            return books;
//        }
//        return books.stream()
//                .filter(book -> book.getCategory().equalsIgnoreCase(category))
//                .toList();
//    }
//
//    // adding a book
//    @PostMapping("/books")
//    public void createBook(Book newBook){
//        boolean isNewBook = books.stream()
//                .noneMatch(book -> book.getTitle()
//                        .equalsIgnoreCase(newBook.getTitle()));
//        if(isNewBook){
//            books.add(newBook);
//        }
//    }
//
//    // updating a book
//    @PutMapping("/books/{id}")
//    public void updateBook(@PathVariable int id,@RequestBody Book updatedBook){
//        for(int i=0;i<books.size();i++){
//            if(books.get(i).getId() == id){
//                books.set(i,updatedBook);
//            }
//        }
//    }
//
//    // deleting a book
//    @DeleteMapping("/books/{id}")
//    public void deleteBook(@PathVariable int id){
//        boolean removed = books.removeIf(book -> book.getId() == id);
//        if(removed){
//            System.out.println("Book has been deleted");
//        }
//        else{
//            System.out.println("Book not found");
//        }
//    }
}
