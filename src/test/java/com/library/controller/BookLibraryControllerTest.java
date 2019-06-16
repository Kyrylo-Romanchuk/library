package com.library.controller;

import com.library.data.dto.BookDto;
import com.library.data.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookLibraryControllerTest {

    @Mock
    List<Book> bookList;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    BookDto bookDto;

    @InjectMocks
    BookLibraryController bookLibraryController;

    @Test
    public void getUrl() {
        when(bookDto.getBookList()).thenReturn(bookList);
        assertEquals("/WEB-INF/library.jsp", bookLibraryController.getUrl(httpServletRequest));
        verify(httpServletRequest).setAttribute("books", bookList);
    }
}