package com.library.validator;

import com.library.data.converter.DateConverter;
import com.library.data.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorValidatorTest {
    @Mock
    private Author author;

    private DateConverter dateConverter = new DateConverter();
    private AuthorValidator authorValidator = new AuthorValidator();

    @Test
    public void validate() {
        when(author.getFirstName()).thenReturn("test");
        when(author.getLastName()).thenReturn("test");
        when(author.getBirthDay()).thenReturn(dateConverter.convert("01/01/1990"));
        when(author.getBiography()).thenReturn("this is the test author");

        assertEquals(0, authorValidator.validate(author).getResultMap().size());

        when(author.getFirstName()).thenReturn("");
        assertEquals(1, authorValidator.validate(author).getResultMap().size());
    }
}
