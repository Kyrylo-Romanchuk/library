package com.library.data.converter;

import com.library.data.dao.BookDao;
import com.library.data.model.Book;
import com.library.data.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookConverterTest {

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    Book book;

    @Mock
    BookConverter bookConverter;

    @Test
    public void convert() {
        when(httpServletRequest.getParameter("bookName")).thenReturn("test");
        when(httpServletRequest.getParameter("bookYear")).thenReturn("1990");
        when(httpServletRequest.getParameter("bookAuthor")).thenReturn("Testicho");
        when(httpServletRequest.getParameter("bookInfo")).thenReturn("there is a test book");
        when(httpServletRequest.getParameter("bookLanguage")).thenReturn("English");

        when(bookConverter.convert(httpServletRequest)).thenReturn(book);

        book = bookConverter.convert(httpServletRequest);

//        when(book.getName()).thenReturn("test");
//        when(book.getYear()).thenReturn(1990);
//        when(book.getAuthor()).thenReturn("Testicho");
//        when(book.getInfo()).thenReturn("there is a test book");
//        when(book.getLanguage()).thenReturn(Language.English);

        assertEquals(book.getName(), "test");
        assertEquals(book.getYear().intValue(), 1990);
        assertEquals(book.getAuthor(), "Testicho");
        assertEquals(book.getInfo(), "there is a test book");
        assertEquals(book.getLanguage(), Language.English);
    }
}