package com.library.data.converter;

import com.library.data.model.Book;
import com.library.data.model.enums.Language;

import javax.servlet.http.HttpServletRequest;

public class BookConverter implements Converter<HttpServletRequest, Book> {
    @Override
    public Book convert(HttpServletRequest request) {
        Book book = new Book();
        book.setName(request.getParameter("bookName"));
        book.setYear(Integer.valueOf(request.getParameter("bookYear")));
        book.setAuthor(request.getParameter("bookAuthor"));
        book.setInfo(request.getParameter("bookInfo"));
        book.setLanguage(Language.valueOf(request.getParameter("bookLanguage")));
        return book;
    }
}
