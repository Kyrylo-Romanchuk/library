package com.library.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private Integer id;
    private String name;
    private Integer year;
    private Author author;
    private String info;
    private Language language;
    private List<Genre> genres = new ArrayList<>();

    @Override
    public int compareTo(Book o) {
        return name.compareTo(o.getName());
    }

    public Book() {
    }

    public Book(Integer id, String name, Integer year, Author author, String info, Language language, List<Genre> genres) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.info = info;
        this.language = language;
        this.genres = genres;
    }

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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
