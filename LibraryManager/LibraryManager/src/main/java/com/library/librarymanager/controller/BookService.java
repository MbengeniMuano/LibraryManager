package com.library.librarymanager.controller;

import com.library.librarymanager.model.Book;
import com.library.librarymanager.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public String deleteBook(@RequestParam(required = false) String isbn,
                             @RequestParam(required = false) String author,
                             @RequestParam(required = false) String title,
                             RedirectAttributes redirectAttributes) {
        if (isbn != null && !isbn.isEmpty()) {
            // Delete book by ISBN
            bookRepository.deleteByIsbn(isbn);
        } else if (author != null && !author.isEmpty()) {
            // Delete book by author
            bookRepository.deleteByAuthor(author);
        } else if (title != null && !title.isEmpty()) {
            // Delete book by title
            bookRepository.deleteByTitle(title);
        }

        redirectAttributes.addFlashAttribute("successMessage", "Book deleted successfully.");
        return "redirect:/books";
    }

}