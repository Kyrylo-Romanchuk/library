package com.library.validator;

import com.library.data.model.Genre;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GenreValidatorTest {
    @Test
    public void validate() {
        Genre genre = new Genre();
        genre.setName("test");

        GenreValidator genreValidator = new GenreValidator();

        assertTrue(genreValidator.validate(genre).isSuccess());
    }
}