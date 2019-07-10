package com.library.validator;

import com.library.data.model.Author;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthorValidatorTest {
    private AuthorValidator authorValidator = new AuthorValidator();

    @Test
    public void validate() throws ParseException {
        Author author = new Author();
        author.setBiography("test");
        author.setFirstName("test");
        author.setLastName("test");
        author.setBirthDay(new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1990"));

        assertTrue(authorValidator.validate(author).isSuccess());

        author.setFirstName("");
        assertFalse(authorValidator.validate(author).isSuccess());
    }
}
