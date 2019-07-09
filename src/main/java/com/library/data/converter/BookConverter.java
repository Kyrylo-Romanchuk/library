package com.library.data.converter;

import com.library.data.dao.AuthorDao;
import com.library.data.dao.LanguageDao;
import com.library.data.model.Book;

import javax.servlet.http.HttpServletRequest;

public class BookConverter implements Converter<HttpServletRequest, Book> {
    private AuthorDao authorDao;
    private LanguageDao languageDao;
    private IntegerConverter integerConverter;

    public BookConverter(AuthorDao authorDao, LanguageDao languageDao, IntegerConverter integerConverter) {
        this.authorDao = authorDao;
        this.languageDao = languageDao;
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
        Integer languageId = integerConverter.convert(request.getParameter("bookLanguage"));
        book.setLanguage(languageDao.findById(languageId));
        return book;
    }
}
