package com.library.data.converter;

import com.library.data.dto.AuthorDto;
import com.library.data.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorToDtoConverterTest {
    @Mock
    private Author author;

    private AuthorToDtoConverter authorToDtoConverter = new AuthorToDtoConverter();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");


    @Test
    public void convert() throws ParseException {
        Date birthday = simpleDateFormat.parse("01/20/1991");
        Date dieDay = simpleDateFormat.parse("06/30/2090");
        when(author.getId()).thenReturn(1);
        when(author.getFirstName()).thenReturn("test");
        when(author.getLastName()).thenReturn("test");
        when(author.getBiography()).thenReturn("test");
        when(author.getFullName()).thenReturn("test test");
        when(author.getBirthDay()).thenReturn(birthday);
        when(author.getDieDay()).thenReturn(dieDay);

        AuthorDto authorDto = authorToDtoConverter.convert(author);

        assertEquals(1, authorDto.getId().intValue());
        assertEquals("test", authorDto.getFirstName());
        assertEquals("test", authorDto.getLastName());
        assertEquals("test test", authorDto.getFullName());
        assertEquals("test", authorDto.getBiography());
        assertEquals(birthday, authorDto.getBirthDay());
        assertEquals(dieDay, authorDto.getDieDay());
    }
}