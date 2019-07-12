package com.library.data.converter;

import com.library.data.model.Genre;

import javax.servlet.http.HttpServletRequest;

public class GenreConverter implements Converter <HttpServletRequest, Genre> {
    private final IntegerConverter integerConverter;

    public GenreConverter(IntegerConverter integerConverter) {
        this.integerConverter = integerConverter;
    }

    @Override
    public Genre convert(HttpServletRequest request) {
        Genre genre = new Genre();
        genre.setId(integerConverter.convert(request.getParameter("id")));
        genre.setName(request.getParameter("name"));
        return genre;
    }
}
