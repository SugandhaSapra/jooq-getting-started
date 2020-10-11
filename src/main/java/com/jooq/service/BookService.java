package com.jooq.service;


import com.jooq.entities.tables.pojos.Book;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jooq.entities.Tables.BOOK;

@Service
@RequiredArgsConstructor
public class BookService {
    private final DSLContext dslContext;

    public List<Book> getBooks() {
        return dslContext.selectFrom(BOOK)
                .fetchInto(Book.class);
    }

    public void insertBook(Book book) {
        dslContext
                .insertInto(BOOK,BOOK.ID, BOOK.AUTHOR, BOOK.TITLE)
                .values(book.getId(), book.getAuthor(), book.getTitle())
                .execute();

    }
}
