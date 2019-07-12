package com.library.controller;

import com.library.data.converter.AuthorToDtoConverter;
import com.library.data.converter.BookConverter;
import com.library.data.converter.BookToDtoConverter;
import com.library.data.converter.IntegerConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.dao.GenreDao;
import com.library.data.dao.LanguageDao;
import com.library.data.dto.BookDto;
import com.library.data.model.Book;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookLibraryControllerTest {
    @Mock
    private Book book;

    @Mock
    private BookDao bookDao;

    @Mock
    private List<Book> bookList;

    @Mock
    private List<BookDto> bookDtoList;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private BookConverter bookConverter;

    @Mock
    private IntegerConverter integerConverter;

    @Mock
    private BookToDtoConverter bookToDtoConverter;

    @Mock
    private AuthorToDtoConverter authorToDtoConverter;

    @Mock
    private AuthorDao authorDao;

    @Mock
    private LanguageDao languageDao;

    @Mock
    private GenreDao genreDao;

    @Mock
    private Validator<Book> bookValidator;

    private BookLibraryController bookLibraryController;

    @Before
    public void init() {
        bookLibraryController = new BookLibraryController(bookDao, authorDao, languageDao, genreDao, bookConverter, authorToDtoConverter, bookToDtoConverter, integerConverter, bookValidator);
    }

    @Test
    public void showBookList() {
        when(bookDao.getAll()).thenReturn(bookList);
        when(bookToDtoConverter.convert(bookList)).thenReturn(bookDtoList);
        assertEquals("/books/library.jsp", bookLibraryController.showBookList(httpServletRequest));
        verify(httpServletRequest).setAttribute("books", bookDtoList);
    }

    @Test
    public void showAddNewBook() {
        assertEquals("/books/bookAdd.jsp", bookLibraryController.showAddNewBook(httpServletRequest));
        verify(httpServletRequest).setAttribute("languages", languageDao.getAll());
        verify(httpServletRequest).setAttribute("authors", authorDao.getAll());
        verify(httpServletRequest).setAttribute("genres", genreDao.getAll());
    }

    @Test
    public void addNewBook() {
        when(bookConverter.convert(httpServletRequest)).thenReturn(book);
        when(bookValidator.validate(book)).thenReturn(new ValidationResult());
        assertEquals("redirect:/books", bookLibraryController.addNewBook(httpServletRequest));
        verify(bookDao).save(book);
    }
}