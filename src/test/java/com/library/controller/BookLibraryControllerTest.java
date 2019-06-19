package com.library.controller;

import com.library.data.converter.BookConverter;
import com.library.data.dao.BookDao;
import com.library.data.model.Book;
import com.library.data.model.Language;
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
    List<Book> bookList;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    BookDao bookDao;

    @Mock
    Book book;

    @Mock
    BookConverter bookConverter;

    @InjectMocks
    BookLibraryController bookLibraryController;

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
    }

    @Test
    public void addNewBook() {
        when(bookConverter.convert(httpServletRequest)).thenReturn(book);
        assertEquals("redirect:/books", bookLibraryController.addNewBook(httpServletRequest));
        verify(bookDao).add(book);
    }
}