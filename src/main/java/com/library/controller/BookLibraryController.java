package com.library.controller;

import com.library.data.converter.Converter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.model.Book;
import com.library.data.model.Language;

import javax.servlet.http.HttpServletRequest;

public class BookLibraryController {
    private final BookDao bookDao;
    private final Converter<HttpServletRequest, Book> bookConverter;
    private final AuthorDao authorDao;

    public BookLibraryController(BookDao bookDao, AuthorDao authorDao, Converter<HttpServletRequest, Book> bookConverter) {
        this.bookDao = bookDao;
        this.bookConverter = bookConverter;
        this.authorDao = authorDao;
    }

    public String showBookList(HttpServletRequest request) {
        request.setAttribute("books", bookDao.getAll());
        return "/books/library.jsp";
    }

    public String showAddNewBook(HttpServletRequest request) {
        request.setAttribute("languages", Language.values());
        request.setAttribute("authors", authorDao.getAll());
        return "/books/bookAdd.jsp";
    }

    public String addNewBook(HttpServletRequest request) {
        bookDao.add(bookConverter.convert(request));
        return "redirect:/books";
    }
}
