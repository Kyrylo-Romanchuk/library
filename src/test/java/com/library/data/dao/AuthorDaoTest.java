package com.library.data.dao;

import com.library.data.model.Author;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AuthorDaoTest {

    private List<Author> authorList = new ArrayList<>();
    private AuthorDao authorDao;

    @Before
    public void init() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        authorList.add(new Author(1, "Taras", "Shevchenko", "very bad author", simpleDateFormat.parse("09/03/1814"), simpleDateFormat.parse("10/03/1861")));
        authorList.add(new Author(2, "John Ronald Reuel", "Tolkien", "so good author", simpleDateFormat.parse("03/01/1892"), simpleDateFormat.parse("02/09/1973")));
        authorList.add(new Author(3, "Robert Anthony", "Salvatore", "dark elf", simpleDateFormat.parse("20/01/1959"), simpleDateFormat.parse("00/00/0000")));
    }

    @Test
    public void getAuthorsList() {
        authorDao = new AuthorDao(authorList);
        assertArrayEquals(authorList.toArray(), authorDao.getAll().toArray());
    }

    @Test
    public void findAuthorById() {
        authorDao = new AuthorDao(authorList);
        assertEquals(authorList.get(0), authorDao.findById(1));
    }
}