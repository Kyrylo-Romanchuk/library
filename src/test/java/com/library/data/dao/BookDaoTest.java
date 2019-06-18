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
    List<Book> bookList;

    @InjectMocks
    BookDao bookDao;

    @Test
    public void getBookList() {
        assertArrayEquals(bookList.toArray(), bookDao.getBookList().toArray());
    }
}