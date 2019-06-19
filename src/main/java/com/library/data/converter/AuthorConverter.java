package com.library.data.converter;

import com.library.data.model.Author;

import javax.servlet.http.HttpServletRequest;

public class AuthorConverter implements Converter<HttpServletRequest, Author> {

    private final DateConverter dateConverter = new DateConverter();

    @Override
    public Author convert(HttpServletRequest request) throws Exception {
        Author author = new Author();
        author.setId(Integer.valueOf(request.getParameter("id")));
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
        author.setBiography(request.getParameter("biography"));
        author.setBirthDay(dateConverter.convert(request.getParameter("birthDay")));
        author.setDieDay(dateConverter.convert(request.getParameter("dieDay")));
        return author;
    }
}
