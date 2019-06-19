package com.library.data.dao;

import com.library.data.converter.DateConverter;
import com.library.data.model.Author;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class AuthorDaoTest {

    List<Author> authorList = new ArrayList<>();
    DateConverter dateConverter = new DateConverter();
    AuthorDao authorDao;

    @Test
    public void getAuthorsList() {

        try {
            authorList.add(new Author(1, "Taras", "Shevchenko", "very bad author", dateConverter.convert("09/03/1814"), dateConverter.convert("10/03/1861")));
            authorList.add(new Author(2, "John Ronald Reuel", "Tolkien", "so good author", dateConverter.convert("03/01/1892"), dateConverter.convert("02/09/1973")));
            authorList.add(new Author(3, "Robert Anthony", "Salvatore", "dark elf", dateConverter.convert("20/01/1959"), dateConverter.convert("00/00/0000")));
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

        authorDao = new AuthorDao(authorList);

        assertArrayEquals(authorList.toArray(), authorDao.getAuthorsList().toArray());
    }
}