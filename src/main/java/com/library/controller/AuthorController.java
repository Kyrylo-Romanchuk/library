package com.library.controller;

import com.library.data.converter.AuthorConverter;
import com.library.data.dao.AuthorDao;

import javax.servlet.http.HttpServletRequest;

public class AuthorController {
    private final AuthorDao authorDao;
    private final AuthorConverter authorConverter;

    public AuthorController(AuthorDao authorDao, AuthorConverter authorConverter) {
        this.authorDao = authorDao;
        this.authorConverter = authorConverter;
    }

    public String showAuthorList(HttpServletRequest request) {
        request.setAttribute("authors", authorDao.getAuthorsList());
        return "/authors/authorsList.jsp";
    }

    public String showAddAuthor(HttpServletRequest request) {
        return "/authors/authorAdd.jsp";
    }

    public String addAuthor(HttpServletRequest request) {
        try {
            authorDao.addAuthor(authorConverter.convert(request));
            return "redirect:/authors";
        } catch (Exception e){
            request.setAttribute("error", e.toString());
            return "/authors/authorAdd.jsp";
        }
    }
}
