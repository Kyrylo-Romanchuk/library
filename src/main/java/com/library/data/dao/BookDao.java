package com.library.data.dao;

import com.library.data.model.Book;

import java.util.List;

public class BookDao implements CommonDao<Book> {
    private List<Book> books;

    public BookDao(List<Book> bookList) {
        this.books = bookList;
    }

    @Override
    public void add(Book book) {
        if (book.getId() == null) {
            Integer maxId = books.stream().map(Book::getId).max(Integer::compareTo).orElse(0);
            book.setId(maxId + 1);
        }
        books.add(book);
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
        return null;
    }
}
