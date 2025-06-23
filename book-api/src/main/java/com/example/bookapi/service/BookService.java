
package com.example.bookapi.service;

import com.example.bookapi.entity.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book book = repo.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setYearPublished(updatedBook.getYearPublished());
            return repo.save(book);
        }
        return null;
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
