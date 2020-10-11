package com.jooq.controller;

import com.jooq.entities.tables.pojos.Book;
import com.jooq.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }
    @PostMapping
    public void postBook(@RequestBody Book book){
        this.bookService.insertBook(book);
    }
}
