package com.library.validator;

import com.library.data.model.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GenreValidatorTest {

    @Mock
    Genre genre;

    @Test
    public void validate() {
        GenreValidator genreValidator = new GenreValidator();
        when(genre.getName()).thenReturn("test");

        assertEquals(0, genreValidator.validate(genre).getResultMap().size());
    }
}