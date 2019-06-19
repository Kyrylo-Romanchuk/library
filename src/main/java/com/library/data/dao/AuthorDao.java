package com.library.data.dao;

import com.library.data.model.Author;

import java.util.List;

public class AuthorDao {
    private List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor (Author author){
        authors.add(author);
    }

    public List<Author> getAuthorsList (){
        return authors;
    }

    public Author findAuthorById (int id){
        return authors.stream().filter(author -> id == author.getId()).findFirst().get();
    }
}
