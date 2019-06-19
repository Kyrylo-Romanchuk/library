package com.library.data.converter;

import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.enums.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookConverterTest {

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    AuthorDao authorDao;

    private Author author;
    private DateConverter dateConverter = new DateConverter();
    private BookConverter bookConverter = new BookConverter(authorDao);

    @Test
    public void convert() {

        try {
            author = new Author(1, "Taras", "Shevchenko", "very bad author", dateConverter.convert("09/03/1814"), dateConverter.convert("10/03/1861"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        when(authorDao.findAuthorById(1)).thenReturn(author);
        when(httpServletRequest.getParameter("bookName")).thenReturn("test");
        when(httpServletRequest.getParameter("bookYear")).thenReturn("1990");
        when(httpServletRequest.getParameter("bookAuthor")).thenReturn("1");
        when(httpServletRequest.getParameter("bookInfo")).thenReturn("there is a test book");
        when(httpServletRequest.getParameter("bookLanguage")).thenReturn("English");

        Book book = bookConverter.convert(httpServletRequest);

        assertEquals(book.getName(), "test");
        assertEquals(book.getYear().intValue(), 1990);
        assertEquals(book.getAuthor(), author);
        assertEquals(book.getInfo(), "there is a test book");
        assertEquals(book.getLanguage(), Language.English);
    }
}