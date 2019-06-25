package com.library.controller;

import com.library.data.converter.AuthorConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @Mock
    private Author author;

    @Mock
    private List<Author> authorList;

    @Mock
    private HttpServletRequest request;

    @Mock
    private AuthorDao authorDao;

    @Mock
    private AuthorConverter authorConverter;

    @Mock
    private Validator<Author, ValidationResult> authorValidator;

    @InjectMocks
    private AuthorController authorController;

    @Test
    public void showAuthorList() {
        when(authorDao.getAll()).thenReturn(authorList);
        assertEquals("/authors/authorsList.jsp", authorController.showAuthorList(request));
        verify(request).setAttribute("authors", authorList);
    }

    @Test
    public void showAddAuthor() {
        assertEquals("/authors/authorAdd.jsp", authorController.showAddAuthor(request));
    }

    @Test
    public void addAuthor() {
        when(authorConverter.convert(request)).thenReturn(author);
        when(authorValidator.validate(author)).thenReturn(new ValidationResult());
        assertEquals("redirect:/authors", authorController.addAuthor(request));
        verify(authorDao).add(author);
    }
}