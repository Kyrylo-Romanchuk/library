package com.library.controller;

import com.library.data.converter.BookConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.model.Book;
import com.library.data.model.Language;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;
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
    private List<Book> bookList;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private BookDao bookDao;

    @Mock
    private Book book;

    @Mock
    private BookConverter bookConverter;

    @Mock
    private AuthorDao authorDao;

    @Mock
    private Validator<Book, ValidationResult> bookValidator;

    @InjectMocks
    private BookLibraryController bookLibraryController;

    @Test
    public void showBookList() {
        when(bookDao.getAll()).thenReturn(bookList);
        assertEquals("/books/library.jsp", bookLibraryController.showBookList(httpServletRequest));
        verify(httpServletRequest).setAttribute("books", bookList);
    }

    @Test
    public void showAddNewBook() {
        assertEquals("/books/bookAdd.jsp", bookLibraryController.showAddNewBook(httpServletRequest));
        verify(httpServletRequest).setAttribute("languages", Language.values());
        verify(httpServletRequest).setAttribute("authors", authorDao.getAll());
    }

    @Test
    public void addNewBook() {
        when(bookConverter.convert(httpServletRequest)).thenReturn(book);
        when(bookValidator.validate(book)).thenReturn(new ValidationResult());
        assertEquals("redirect:/books", bookLibraryController.addNewBook(httpServletRequest));
        verify(bookDao).add(book);
    }
}