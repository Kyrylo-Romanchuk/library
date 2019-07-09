package com.library.data.dao;

import com.library.data.model.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GenreDaoTest {

    private List<Genre> genreList;
    private GenreDao genreDao;

    @Before
    public void init (){
        genreList = new ArrayList<>();
        genreList.add(new Genre(1, "Classic"));
        genreList.add(new Genre(2, "Drama"));
        genreList.add(new Genre(3, "Fantasy"));
        genreDao = new GenreDao(genreList);
    }

    @Test
    public void add() {
        int size = genreList.size();
        genreDao.add(new Genre(3, "Test"));
        assertEquals(++size, genreDao.getAll().size());
    }

    @Test
    public void getAll() {
        assertArrayEquals(genreList.toArray(), genreDao.getAll().toArray());
    }

    @Test
    public void findById() {
        assertEquals(genreList.get(0), genreDao.findById(1));
    }
}