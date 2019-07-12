package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.GenreConverter;
import com.library.data.converter.IntegerConverter;
import com.library.data.dao.GenreDao;
import com.library.data.model.Genre;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class GenreController implements Controller {
    private final GenreConverter genreConverter;
    private final GenreDao genreDao;
    private final Validator<Genre> genreValidator;
    private final IntegerConverter integerConverter;

    public GenreController(GenreDao genreDao, GenreConverter genreConverter, IntegerConverter integerConverter, Validator<Genre> genreValidator) {
        this.genreDao = genreDao;
        this.genreConverter = genreConverter;
        this.integerConverter = integerConverter;
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

    @GetMapping("/genres/edit")
    public String bookEdit(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        request.setAttribute("genre", genreDao.findById(id));
        return showAddGenre(request);
    }

    @PostMapping("/genres/add")
    public String add(HttpServletRequest request) {
        Genre genre = genreConverter.convert(request);
        ValidationResult validationResult = genreValidator.validate(genre);
        if (validationResult.isSuccess()) {
            genreDao.save(genre);
            return "redirect:/genres";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("genre", genre);
            return showAddGenre(request);
            // TODO: 7/10/2019 redirect  return "redirect:/languages/add";
        }
    }

    @PostMapping("/genres/delete")
    public String delete(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        genreDao.delete(id);
        return showGenreList(request);
    }
}
