package com.library.data.dao;

import com.library.data.model.Author;

import java.util.List;

public class AuthorDao implements CommonDao<Author> {
    private List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public void add(Author author) {
        if (author.getId() == null) {
            Integer maxId = authors.stream().map(Author::getId).max(Integer::compareTo).orElse(0);
            author.setId(maxId + 1);
        }
        authors.add(author);
    }

    @Override
    public List<Author> getAll() {
        return authors;
    }

    @Override
    public Author findById(Integer id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }
}
