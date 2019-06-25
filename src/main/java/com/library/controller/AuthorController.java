package com.library.controller;

import com.library.data.converter.AuthorConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class AuthorController {
    private final AuthorDao authorDao;
    private final AuthorConverter authorConverter;
    private final Validator<Author, ValidationResult> authorValidator;

    public AuthorController(AuthorDao authorDao, AuthorConverter authorConverter,
                            Validator<Author, ValidationResult> authorValidator) {
        this.authorDao = authorDao;
        this.authorConverter = authorConverter;
        this.authorValidator = authorValidator;
    }

    public String showAuthorList(HttpServletRequest request) {
        request.setAttribute("authors", authorDao.getAll());
        return "/authors/authorsList.jsp";
    }

    public String showAddAuthor(HttpServletRequest request) {
        return "/authors/authorAdd.jsp";
    }

    public String addAuthor(HttpServletRequest request) {
        Author author = authorConverter.convert(request);
        ValidationResult validationResult = authorValidator.validate(author);
        if (validationResult.getResultMap().isEmpty()) {
            authorDao.add(authorConverter.convert(request));
            return "redirect:/authors";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("error", "we have some problem");
            return "/authors/authorAdd.jsp";
        }
    }
}
