package com.library.data.converter;

import com.library.data.model.Author;

import javax.servlet.http.HttpServletRequest;

public class AuthorConverter implements Converter<HttpServletRequest, Author> {

    private final DateConverter dateConverter;

    public AuthorConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    @Override
    public Author convert(HttpServletRequest request){
        Author author = new Author();
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
        author.setBiography(request.getParameter("biography"));
        author.setBirthDay(dateConverter.convert(request.getParameter("birthDay")));
        author.setDieDay(dateConverter.convert(request.getParameter("dieDay")));
        return author;
    }
}
