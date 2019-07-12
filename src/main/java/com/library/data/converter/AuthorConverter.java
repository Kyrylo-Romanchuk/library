package com.library.data.converter;

import com.library.data.model.Author;

import javax.servlet.http.HttpServletRequest;

public class AuthorConverter implements Converter<HttpServletRequest, Author> {
    private final DateConverter dateConverter;
    private final IntegerConverter integerConverter;

    public AuthorConverter(DateConverter dateConverter, IntegerConverter integerConverter) {
        this.dateConverter = dateConverter;
        this.integerConverter = integerConverter;
    }

    @Override
    public Author convert(HttpServletRequest request) {
        Author author = new Author();
        author.setId(integerConverter.convert(request.getParameter("id")));
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
        author.setBiography(request.getParameter("biography"));
        author.setBirthDay(dateConverter.convert(request.getParameter("birthDay")));
        author.setDieDay(dateConverter.convert(request.getParameter("dieDay")));
        return author;
    }
}
