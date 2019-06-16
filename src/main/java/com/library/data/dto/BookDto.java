package com.library.data.dto;

import com.library.data.model.Book;
import com.library.data.model.Language;

import java.util.Arrays;
import java.util.List;

public class BookDto {
    private List<Book> books;

    public BookDto(List <Book> bookList) {
        this.books = bookList;
    }

    public List<Book> getBookList() {
        return books;
    }
}
