package com.library.librarymanager.repository;

import com.library.librarymanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods for deleting books

    // Delete book by ISBN
    void deleteByIsbn(String isbn);

    // Delete book by author
    void deleteByAuthor(String author);

    // Delete book by title
    void deleteByTitle(String title);

    // You can add more custom query methods here if needed
}
