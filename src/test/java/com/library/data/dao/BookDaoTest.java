package com.library.data.dao;

import com.library.data.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookDaoTest {

    @Mock
    private List<Book> bookList;

    @InjectMocks
    private BookDao bookDao;

    @Test
    public void getBookList() {
        assertArrayEquals(bookList.toArray(), bookDao.getAll().toArray());
    }
}