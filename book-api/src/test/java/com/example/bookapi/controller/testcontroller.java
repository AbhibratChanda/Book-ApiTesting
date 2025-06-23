package com.example.bookapi.controller;

import com.example.bookapi.entity.Book;
import com.example.bookapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void shouldReturnAllBooks() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Java");
        book.setAuthor("Author");
        book.setGenre("Tech");
        book.setYearPublished(2020);

        given(bookService.getAllBooks()).willReturn(Collections.singletonList(book));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Java")));
    }

    @Test
    void shouldReturnBookById() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Spring Boot");
        book.setAuthor("Rod");
        book.setGenre("Tech");
        book.setYearPublished(2021);

        given(bookService.getBookById(1L)).willReturn(book);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Spring Boot")));
    }


    @Test
    void shouldAddBook() throws Exception {
        Book savedBook = new Book();
        savedBook.setId(1L);
        savedBook.setTitle("New Book");
        savedBook.setAuthor("Author");
        savedBook.setGenre("Fiction");
        savedBook.setYearPublished(2022);

        given(bookService.addBook(any(Book.class))).willReturn(savedBook);

        String bookJson = "{\n" +
                "  \"title\": \"New Book\",\n" +
                "  \"author\": \"Author\",\n" +
                "  \"genre\": \"Fiction\",\n" +
                "  \"yearPublished\": 2022\n" +
                "}";

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("New Book")));
    }
}
