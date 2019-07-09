package com.library.data.converter;

import com.library.data.model.Genre;

import javax.servlet.http.HttpServletRequest;

public class GenreConverter implements Converter <HttpServletRequest, Genre> {
    @Override
    public Genre convert(HttpServletRequest request) {
        Genre genre = new Genre();
        genre.setName(request.getParameter("name"));
        return genre;
    }
}
