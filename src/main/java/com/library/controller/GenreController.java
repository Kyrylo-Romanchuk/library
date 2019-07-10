package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.GenreConverter;
import com.library.data.dao.GenreDao;
import com.library.data.model.Genre;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class GenreController implements Controller {
    private final GenreConverter genreConverter;
    private final GenreDao genreDao;
    private final Validator<Genre> genreValidator;

    public GenreController(GenreDao genreDao, GenreConverter genreConverter, Validator<Genre> genreValidator) {
        this.genreDao = genreDao;
        this.genreConverter = genreConverter;
        this.genreValidator = genreValidator;
    }

    @GetMapping("/genres")
    public String showGenreList(HttpServletRequest request) {
        request.setAttribute("genres", genreDao.getAll());
        return "/genres/genresList.jsp";
    }

    @GetMapping("/genres/add")
    public String showAddGenre(HttpServletRequest request) {
        return "/genres/genreAdd.jsp";
    }

    @PostMapping("/genres/add")
    public String add(HttpServletRequest request) {
        Genre genre = genreConverter.convert(request);
        ValidationResult validationResult = genreValidator.validate(genre);
        if (validationResult.isSuccess()) {
            genreDao.add(genre);
            return "redirect:/genres";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("genre", genre);
            return showAddGenre(request);
            // TODO: 7/10/2019 redirect  return "redirect:/languages/add";
        }
    }
}
