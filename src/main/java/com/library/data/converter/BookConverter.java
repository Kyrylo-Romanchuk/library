package com.library.data.converter;

import com.library.data.dao.AuthorDao;
import com.library.data.model.Book;
import com.library.data.model.Language;

import javax.servlet.http.HttpServletRequest;

public class BookConverter implements Converter<HttpServletRequest, Book> {
    private AuthorDao authorDao;
    private IntegerConverter integerConverter;

    public BookConverter(AuthorDao authorDao, IntegerConverter integerConverter) {
        this.authorDao = authorDao;
        this.integerConverter = integerConverter;
    }

    @Override
    public Book convert(HttpServletRequest request) {
        Book book = new Book();
        book.setName(request.getParameter("bookName"));
        book.setYear(integerConverter.convert(request.getParameter("bookYear")));
        Integer id = integerConverter.convert(request.getParameter("bookAuthor"));
        book.setAuthor(authorDao.findById(id));
        book.setInfo(request.getParameter("bookInfo"));
        book.setLanguage(Language.valueOf(request.getParameter("bookLanguage")));
        return book;
    }
}
