package com.library.data.converter;

import com.library.data.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorConverterTest {

    @Mock
    HttpServletRequest request;

    private Author author;

    AuthorConverter authorConverter = new AuthorConverter();

    @Test
    public void convert() {
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("firstName")).thenReturn("test");
        when(request.getParameter("lastName")).thenReturn("testLast");
        when(request.getParameter("biography")).thenReturn("test biography");
        when(request.getParameter("birthDay")).thenReturn("20/01/1991");
        when(request.getParameter("dieDay")).thenReturn("30/06/2090");

        DateConverter dateConverter = new DateConverter();

        try {
            author = new AuthorConverter().convert(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(1, author.getId());
        assertEquals("test", author.getFirstName());
        assertEquals("testLast", author.getLastName());
        assertEquals("test biography", author.getBiography());
        try {
            assertEquals(dateConverter.convert("20/01/1991"), author.getBirthDay());
            assertEquals(dateConverter.convert("30/06/2090"), author.getDieDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}