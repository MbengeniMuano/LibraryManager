package com.library.librarymanager.controller;

import com.library.librarymanager.model.Book;
import com.library.librarymanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        if (savedBook != null) {
            return ResponseEntity.ok("Book saved successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to save book");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
