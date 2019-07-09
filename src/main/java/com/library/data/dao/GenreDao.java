package com.library.data.dao;

import com.library.data.model.Genre;

import java.util.List;

public class GenreDao implements CommonDao<Genre> {

    private List<Genre> genres;

    public GenreDao(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public void add(Genre genre) {
        if (genre.getId() == null) {
            Integer maxId = genres.stream().map(Genre::getId).max(Integer::compareTo).orElse(0);
            genre.setId(maxId + 1);
        }
        genres.add(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genres;
    }

    @Override
    public Genre findById(int id) {
        return genres.stream().filter(genre -> genre.getId() == id).findFirst().orElse(null);
    }
}
