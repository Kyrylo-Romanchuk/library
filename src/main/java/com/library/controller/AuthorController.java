package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.AuthorConverter;
import com.library.data.converter.AuthorToDtoConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.model.Author;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

public class AuthorController implements Controller {
    private final AuthorDao authorDao;
    private final AuthorConverter authorConverter;
    private final Validator<Author> authorValidator;
    private final AuthorToDtoConverter authorToDtoConverter;

    public AuthorController(AuthorDao authorDao, AuthorConverter authorConverter,
                            Validator<Author> authorValidator,
                            AuthorToDtoConverter authorToDtoConverter) {
        this.authorDao = authorDao;
        this.authorConverter = authorConverter;
        this.authorValidator = authorValidator;
        this.authorToDtoConverter = authorToDtoConverter;
    }

    @GetMapping("/authors")
    public String showAuthorList(HttpServletRequest request) {
        request.setAttribute("authors", authorDao.getAll().stream()
                .map(authorToDtoConverter::convert)
                .collect(Collectors.toList()));
        return "/authors/authorsList.jsp";
    }

    @GetMapping("/authors/add")
    public String showAddAuthor(HttpServletRequest request) {
        return "/authors/authorAdd.jsp";
    }

    @PostMapping("/authors/add")
    public String addAuthor(HttpServletRequest request) {
        Author author = authorConverter.convert(request);
        ValidationResult validationResult = authorValidator.validate(author);
        if (validationResult.getResultMap().isEmpty()) {
            authorDao.add(author);
            return "redirect:/authors";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("author", author);
            return showAddAuthor(request);
//            return "redirect:/authors/add";
        }
    }
}
