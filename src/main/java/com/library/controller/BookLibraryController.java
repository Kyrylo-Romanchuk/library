package com.library.controller;

import com.library.data.converter.BookConverter;
import com.library.data.dao.BookDao;
import com.library.data.model.Language;

import javax.servlet.http.HttpServletRequest;

public class BookLibraryController {
    private final BookDao bookDao;
    private final BookConverter bookConverter;

    public BookLibraryController(BookDao bookDao, BookConverter bookConverter) {
        this.bookDao = bookDao;
        this.bookConverter = bookConverter;
    }

    public String showBookList(HttpServletRequest request) {
        request.setAttribute("books", bookDao.getBookList());
        return "/WEB-INF/library.jsp";
    }

    public String showAddNewBook(HttpServletRequest request) {
        request.setAttribute("languages", Language.values());
        return "/WEB-INF/bookAdd.jsp";
    }

    public String addNewBook(HttpServletRequest request) {
        request.getSession().setAttribute("redirect", true);
        bookDao.addNewBook(bookConverter.convert(request));
        return "/books";
    }
}
