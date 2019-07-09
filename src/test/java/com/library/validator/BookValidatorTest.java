package com.library.validator;

import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookValidatorTest {

    @Mock
    private Book book;

    @Mock
    private Author author;

    @Mock
    private Language language;

    private BookValidator bookValidator = new BookValidator();

    @Test
    public void validate() {
        when(book.getName()).thenReturn("test");
        when(book.getYear()).thenReturn(1990);
        when(book.getAuthor()).thenReturn(author);
        when(book.getInfo()).thenReturn("this is test book");
        when(book.getLanguage()).thenReturn(language);

        assertEquals(0, bookValidator.validate(book).getResultMap().size());

        when(book.getName()).thenReturn("");
        assertEquals(1, bookValidator.validate(book).getResultMap().size());
    }
}
