package com.library.data.converter;

import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookConverterTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private AuthorDao authorDao;

    @Mock
    private IntegerConverter integerConverter;

    @Mock
    private Author author;

    @Test
    public void convert() throws ParseException {
        BookConverter bookConverter = new BookConverter(authorDao, integerConverter);

        when(authorDao.findById(1)).thenReturn(author);
        when(httpServletRequest.getParameter("bookName")).thenReturn("test");
        when(httpServletRequest.getParameter("bookYear")).thenReturn("1990");
        when(httpServletRequest.getParameter("bookAuthor")).thenReturn("1");
        when(httpServletRequest.getParameter("bookInfo")).thenReturn("there is a test book");
        when(httpServletRequest.getParameter("bookLanguage")).thenReturn("English");
        when(integerConverter.convert("1990")).thenReturn(1990);
        when(integerConverter.convert("1")).thenReturn(1);

        Book book = bookConverter.convert(httpServletRequest);

        assertEquals(book.getName(), "test");
        assertEquals(book.getYear().intValue(), 1990);
        assertEquals(book.getAuthor(), author);
        assertEquals(book.getInfo(), "there is a test book");
        assertEquals(book.getLanguage(), Language.English);
    }
}