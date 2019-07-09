package com.library.data.dao;

import com.library.data.model.Language;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LanguageDaoTest {

    private List<Language> languageList = new ArrayList<>();
    private LanguageDao languageDao;

    @Before
    public void init() {
        languageList.add(new Language(1, "Test", "ts"));
        languageList.add(new Language(2, "Test2", "ts2"));

        languageDao = new LanguageDao(languageList);
    }

    @Test
    public void add() {
        int size = languageList.size();
        languageDao.add(new Language(3, "Test3", "ts3"));
        assertEquals(++size, languageDao.getAll().size());
    }

    @Test
    public void getAll() {
        assertArrayEquals(languageList.toArray(), languageDao.getAll().toArray());
    }

    @Test
    public void findById() {
        assertEquals(languageList.get(1), languageDao.findById(2));
    }
}