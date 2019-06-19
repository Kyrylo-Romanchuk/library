package com.library.controller;

import com.library.data.converter.AuthorConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorControllerTest {

    @Mock
    Author author;

    @Mock
    List<Author> authorList;

    @Mock
    HttpServletRequest request;

    @Mock
    AuthorDao authorDao;

    @Mock
    AuthorConverter authorConverter;

    @InjectMocks
    AuthorController authorController;

    @Test
    public void showAuthorList() {
        when(authorDao.getAuthorsList()).thenReturn(authorList);
        assertEquals("/authors/authorsList.jsp", authorController.showAuthorList(request));
        verify(request).setAttribute("authors", authorList);
    }

    @Test
    public void showAddAuthor() {
        assertEquals("/authors/authorAdd.jsp", authorController.showAddAuthor(request));
    }

    @Test
    public void addAuthor() {
        try {
            when(authorConverter.convert(request)).thenReturn(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("redirect:/authors", authorController.addAuthor(request));
        verify(authorDao).addAuthor(author);
    }
}