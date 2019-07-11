package com.library.data.dto;

import com.library.data.model.Genre;
import com.library.data.model.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDto {
    private Integer id;
    private String name;
    private Integer year;
    private AuthorDto author;
    private String info;
    private Language language;
    private List<Genre> genres = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getGenresString() {
        return genres.stream().map(Genre::getName).collect(Collectors.joining(", "));
    }

    public Genre getGenreById(int id) {
        return genres.stream().filter(genre -> genre.getId() == id).findFirst().orElse(null);
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
