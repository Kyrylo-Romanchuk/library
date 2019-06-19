package com.library.data.dao;

import com.library.data.model.Author;

import java.util.List;

public class AuthorDao {
    private List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public void add(Author author) {
        if (author.getId() == null) {
            Integer maxId = authors.stream().map(Author::getId).max(Integer::compareTo).orElse(0);
            author.setId(maxId + 1);
        }
        authors.add(author);
    }

    public List<Author> getAll() {
        return authors;
    }

    public Author findById(int id) {
        return authors.stream().filter(author -> id == author.getId()).findFirst().orElse(null);
    }
}
