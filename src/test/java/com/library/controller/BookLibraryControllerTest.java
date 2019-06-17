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
import org.mockito.stubbing.OngoingStubbing;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    BookConverter bookConverter;

    @Mock
    HttpSession httpSession;

    @InjectMocks
    BookLibraryController bookLibraryController;

    @Test
    public void showBookList() {
        when(bookDao.getBookList()).thenReturn(bookList);
        assertEquals("/WEB-INF/library.jsp", bookLibraryController.showBookList(httpServletRequest));
        verify(httpServletRequest).setAttribute("books", bookList);
    }

    @Test
    public void showAddNewBook() {
        assertEquals("/WEB-INF/library.jsp", bookLibraryController.showAddNewBook(httpServletRequest));
        verify(httpServletRequest).setAttribute("languages", Language.values());
    }

    @Test
    public void addNewBook() {
        when(httpServletRequest.getAttribute("bookName")).thenReturn("test");
        when(httpServletRequest.getAttribute("bookYear")).thenReturn("1990");
        when(httpServletRequest.getAttribute("bookAuthor")).thenReturn("Testicho");
        when(httpServletRequest.getAttribute("bookInfo")).thenReturn("there is a test book");
        when(httpServletRequest.getAttribute("bookLanguage")).thenReturn("English");
        when(httpServletRequest.getSession(true)).thenReturn(httpSession);
        httpServletRequest.getSession().setAttribute("redirect", false);
//        httpSession.setAttribute("redirect", false);
//        when(httpServletRequest.getSession()).thenReturn(new HttpSession);
//        httpServletRequest.getSession().setAttribute("redirect", false);

        assertEquals("/books", bookLibraryController.addNewBook(httpServletRequest));
//        verify(httpServletRequest).getSession().setAttribute("redirect", true);
        verify(bookConverter).convert(httpServletRequest);
//        verify(bookDao).addNewBook(bookConverter.convert(httpServletRequest));
    }
}