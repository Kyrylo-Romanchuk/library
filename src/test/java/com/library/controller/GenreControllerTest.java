package com.library.controller;

import com.library.data.converter.GenreConverter;
import com.library.data.dao.GenreDao;
import com.library.data.model.Genre;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GenreControllerTest {

    @Mock
    private Genre genre;

    @Mock
    private GenreDao genreDao;

    @Mock
    private List<Genre> genresList;

    @Mock
    private GenreConverter genreConverter;

    @Mock
    private Validator<Genre> genreValidator;

    @Mock
    private HttpServletRequest request;

    private GenreController genreController;

    @Before
    public void init() {
        genreController = new GenreController(genreDao, genreConverter, genreValidator);
    }

    @Test
    public void showGenreList() {
        when(genreDao.getAll()).thenReturn(genresList);
        assertEquals("/genres/genresList.jsp", genreController.showGenreList(request));
        verify(request).setAttribute("genres", genresList);
    }

    @Test
    public void showAddGenre() {
        assertEquals("/genres/genreAdd.jsp", genreController.showAddGenre(request));
    }

    @Test
    public void add() {
        when(genreConverter.convert(request)).thenReturn(genre);
        when(genreValidator.validate(genre)).thenReturn(new ValidationResult());
        assertEquals("redirect:/genres", genreController.add(request));
        verify(genreDao).add(genre);
    }
}