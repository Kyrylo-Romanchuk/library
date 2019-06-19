package com.library.controller;

import com.library.data.converter.BookConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.model.enums.Language;

import javax.servlet.http.HttpServletRequest;

public class BookLibraryController {
    private final BookDao bookDao;
    private final BookConverter bookConverter;
    private final AuthorDao authorDao;

    public BookLibraryController(BookDao bookDao, AuthorDao authorDao, BookConverter bookConverter) {
        this.bookDao = bookDao;
        this.bookConverter = bookConverter;
        this.authorDao = authorDao;
    }

    public String showBookList(HttpServletRequest request) {
        request.setAttribute("books", bookDao.getBookList());
        return "/books/library.jsp";
    }

    public String showAddNewBook(HttpServletRequest request) {
        request.setAttribute("languages", Language.values());
        request.setAttribute("authors", authorDao.getAuthorsList());
        return "/books/bookAdd.jsp";
    }

    public String addNewBook(HttpServletRequest request) {
        bookDao.addNewBook(bookConverter.convert(request));
        return "redirect:/books";
    }
}
