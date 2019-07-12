package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.AuthorConverter;
import com.library.data.converter.AuthorToDtoConverter;
import com.library.data.converter.IntegerConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class AuthorController implements Controller {
    private final AuthorDao authorDao;
    private final AuthorConverter authorConverter;
    private final Validator<Author> authorValidator;
    private final AuthorToDtoConverter authorToDtoConverter;
    private final IntegerConverter integerConverter;

    public AuthorController(AuthorDao authorDao, AuthorConverter authorConverter,
                            AuthorToDtoConverter authorToDtoConverter, IntegerConverter integerConverter, Validator<Author> authorValidator) {
        this.authorDao = authorDao;
        this.authorConverter = authorConverter;
        this.integerConverter = integerConverter;
        this.authorValidator = authorValidator;
        this.authorToDtoConverter = authorToDtoConverter;
    }

    @GetMapping("/authors")
    public String showAuthorList(HttpServletRequest request) {
        request.setAttribute("authors", authorToDtoConverter.convert(authorDao.getAll()));
        return "/authors/authorsList.jsp";
    }

    @GetMapping("/authors/add")
    public String showAddAuthor(HttpServletRequest request) {
        return "/authors/authorAdd.jsp";
    }

    @GetMapping("/authors/edit")
    public String edit(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        request.setAttribute("author", authorDao.findById(id));
        return showAddAuthor(request);
    }

    @PostMapping("/authors/add")
    public String add(HttpServletRequest request) {
        Author author = authorConverter.convert(request);
        ValidationResult validationResult = authorValidator.validate(author);
        if (validationResult.isSuccess()) {
            authorDao.save(author);
            return "redirect:/authors";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("author", author);
            return showAddAuthor(request);
            // TODO: 7/10/2019 redirect return "redirect:/authors/add";
        }
    }

    @PostMapping("/authors/delete")
    public String delete(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        authorDao.delete(id);
        return showAuthorList(request);
    }
}
