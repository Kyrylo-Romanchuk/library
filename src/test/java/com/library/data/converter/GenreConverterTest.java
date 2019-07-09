package com.library.data.converter;

import com.library.data.model.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GenreConverterTest {

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private GenreConverter genreConverter;

    @Test
    public void convert() {
        when(request.getParameter("name")).thenReturn("test");

        Genre genre = genreConverter.convert(request);

        assertEquals("test", genre.getName());
    }
}