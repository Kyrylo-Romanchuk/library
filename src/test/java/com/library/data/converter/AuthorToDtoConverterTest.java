package com.library.data.converter;

import com.library.data.dto.AuthorDto;
import com.library.data.model.Author;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AuthorToDtoConverterTest {

    private AuthorToDtoConverter authorToDtoConverter = new AuthorToDtoConverter();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Test
    public void convert() throws ParseException {
        Date birthday = simpleDateFormat.parse("01/20/1991");
        Date dieDay = simpleDateFormat.parse("06/30/2090");

        Author author = new Author();
        author.setBirthDay(birthday);
        author.setDieDay(dieDay);
        author.setId(1);
        author.setLastName("test");
        author.setFirstName("test");
        author.setBiography("test");

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