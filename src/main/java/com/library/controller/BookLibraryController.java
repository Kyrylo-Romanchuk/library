package com.library.controller;

import com.library.data.converter.BookConverter;
import com.library.data.dao.BookDao;
import com.library.data.model.Language;

import javax.servlet.http.HttpServletRequest;

public class BookLibraryController {
    private final BookDao bookDao;
    private final BookConverter bookConverter;

    public BookLibraryController(BookDao bookDao) {
        this.bookDao = bookDao;
        bookConverter = new BookConverter();
    }

    public String showBookList(HttpServletRequest request) {
        request.setAttribute("books", bookDao.getBookList());
        return "/WEB-INF/library.jsp";
    }

    public String showAddBook(HttpServletRequest request) {
        request.setAttribute("languages", Language.values());
        return "/WEB-INF/bookAdd.jsp";
    }

    public String addNewBook(HttpServletRequest request){
        bookDao.addNewBook(bookConverter.convert(request));
//        return "/book/add";
        return "/library";
    }
}
