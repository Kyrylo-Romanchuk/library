package com.library.validator;

import com.library.data.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorValidatorTest {
    @Mock
    private Author author;

    private AuthorValidator authorValidator = new AuthorValidator();

    @Test
    public void validate() throws ParseException {
        when(author.getFirstName()).thenReturn("test");
        when(author.getLastName()).thenReturn("test");
        when(author.getBirthDay()).thenReturn(new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1990"));
        when(author.getBiography()).thenReturn("this is the test author");

        assertEquals(0, authorValidator.validate(author).getResultMap().size());

        when(author.getFirstName()).thenReturn("");
        assertEquals(1, authorValidator.validate(author).getResultMap().size());
    }
}
