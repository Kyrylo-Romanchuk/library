package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.Converter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.dao.GenreDao;
import com.library.data.dao.LanguageDao;
import com.library.data.dto.AuthorDto;
import com.library.data.dto.BookDto;
import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class BookLibraryController implements Controller {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final LanguageDao languageDao;
    private final GenreDao genreDao;
    private final Converter<HttpServletRequest, Book> bookConverter;
    private final Converter<Author, AuthorDto> authorAuthorDtoConverter;
    private final Converter<Book, BookDto> bookBookDtoConverter;
    private final Converter<String, Integer> integerConverter;
    private final Validator<Book> bookValidator;

    public BookLibraryController(BookDao bookDao, AuthorDao authorDao,
                                 LanguageDao languageDao, GenreDao genreDao,
                                 Converter<HttpServletRequest, Book> bookConverter,
                                 Converter<Author, AuthorDto> authorAuthorDtoConverter,
                                 Converter<Book, BookDto> bookBookDtoConverter, Converter<String, Integer> integerConverter, Validator<Book> bookValidator) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.languageDao = languageDao;
        this.genreDao = genreDao;
        this.bookConverter = bookConverter;
        this.authorAuthorDtoConverter = authorAuthorDtoConverter;
        this.bookBookDtoConverter = bookBookDtoConverter;
        this.integerConverter = integerConverter;
        this.bookValidator = bookValidator;
    }

    @GetMapping("/books")
    public String showBookList(HttpServletRequest request) {
        request.setAttribute("books", bookBookDtoConverter.convert(bookDao.getAll()));
        return "/books/library.jsp";
    }

    @GetMapping("/books/add")
    public String showAddNewBook(HttpServletRequest request) {
        request.setAttribute("languages", languageDao.getAll());
        request.setAttribute("authors", authorAuthorDtoConverter.convert(authorDao.getAll()));
        request.setAttribute("genres", genreDao.getAll());
        return "/books/bookAdd.jsp";
    }

    @GetMapping("/books/edit")
    public String bookEdit(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        request.setAttribute("book", bookDao.findById(id));
        return showAddNewBook(request);
    }

    @PostMapping("/books/add")
    public String addNewBook(HttpServletRequest request) {
        Book book = bookConverter.convert(request);
        ValidationResult validationResult = bookValidator.validate(book);
        if (validationResult.isSuccess()) {
            bookDao.save(book);
            return "redirect:/books";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("book", book);
            return showAddNewBook(request);
            // TODO: 7/10/2019 redirect return "redirect:/books/add";
        }
    }

    @PostMapping("/books/delete")
    public String deleteBook(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        bookDao.delete(id);
        return "redirect:/books";
    }
}
