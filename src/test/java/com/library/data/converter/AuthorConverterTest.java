package com.library.data.converter;

import com.library.data.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorConverterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private DateConverter dateConverter;

    @Mock
    private IntegerConverter integerConverter;

    @InjectMocks
    private AuthorConverter authorConverter;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Test
    public void convert() throws ParseException {
        Date birthday = simpleDateFormat.parse("01/20/1991");
        Date dieDay = simpleDateFormat.parse("06/30/2090");
        when(dateConverter.convert("01/20/1991")).thenReturn(birthday);
        when(dateConverter.convert("06/30/2090")).thenReturn(dieDay);
        when(request.getParameter("firstName")).thenReturn("test");
        when(request.getParameter("lastName")).thenReturn("testLast");
        when(request.getParameter("biography")).thenReturn("test biography");
        when(request.getParameter("birthDay")).thenReturn("01/20/1991");
        when(request.getParameter("dieDay")).thenReturn("06/30/2090");

        Author author = authorConverter.convert(request);

        assertEquals("test", author.getFirstName());
        assertEquals("testLast", author.getLastName());
        assertEquals("test biography", author.getBiography());
        assertEquals(birthday, author.getBirthDay());
        assertEquals(dieDay, author.getDieDay());
    }
}