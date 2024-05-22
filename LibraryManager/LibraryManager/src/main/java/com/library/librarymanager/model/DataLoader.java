package com.library.librarymanager.model;

import com.library.librarymanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /* Load initial data into the database */
        loadInitialData();
    }

    private void loadInitialData() {
        // Create and save some initial books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 10);
        Book book2 = new Book("1984", "George Orwell", "9780451524935", "Science Fiction", 15);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Classic", 20);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "9780141439518", "Romance", 8);
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488", "Literature", 12);
        Book book6 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 10);
        Book book7 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "9780590353427", "Fantasy", 18);
        Book book8 = new Book("Animal Farm", "George Orwell", "9780451526342", "Classic", 9);
        Book book9 = new Book("Brave New World", "Aldous Huxley", "9780060850524", "Science Fiction", 13);
        Book book10 = new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", "Fantasy", 11);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
        bookRepository.save(book7);
        bookRepository.save(book8);
        bookRepository.save(book9);
        bookRepository.save(book10);
    }
}
