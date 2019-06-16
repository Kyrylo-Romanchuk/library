package com.library.data.dao;

import com.library.data.model.Book;

import java.util.List;

public class BookDao {
    private List<Book> books;

    public BookDao(List <Book> bookList) {
        this.books = bookList;
    }

    public List<Book> getBookList() {
        return books;
    }
}
