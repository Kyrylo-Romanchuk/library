package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.Converter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.model.Book;
import com.library.data.model.Language;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class BookLibraryController implements Controller {
    private final BookDao bookDao;
    private final Converter<HttpServletRequest, Book> bookConverter;
    private final AuthorDao authorDao;
    private final Validator<Book, ValidationResult> bookValidator;

    public BookLibraryController(BookDao bookDao, AuthorDao authorDao,
                                 Converter<HttpServletRequest, Book> bookConverter,
                                 Validator<Book, ValidationResult> bookValidator) {
        this.bookDao = bookDao;
        this.bookConverter = bookConverter;
        this.authorDao = authorDao;
        this.bookValidator = bookValidator;
    }

    @GetMapping("/books")
    public String showBookList(HttpServletRequest request) {
        request.setAttribute("books", bookDao.getAll());
        return "/books/library.jsp";
    }

    @GetMapping("/books/add")
    public String showAddNewBook(HttpServletRequest request) {
        request.setAttribute("languages", Language.values());
        request.setAttribute("authors", authorDao.getAll());
        return "/books/bookAdd.jsp";
    }

    @PostMapping("/books/add")
    public String addNewBook(HttpServletRequest request) {
        Book book = bookConverter.convert(request);
        ValidationResult validationResult = bookValidator.validate(book);
        if (validationResult.getResultMap().size() == 0) {
            bookDao.add(book);
            return "redirect:/books";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("book", book);
            return showAddNewBook(request);
//            return "redirect:/books/add";
        }
    }
}
