package com.library.data.dto;

import com.library.data.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookDtoTest {

    @Mock
    List<Book> bookList;

    @InjectMocks
    BookDto bookDto;

    @Test
    public void getBookList() {
        assertArrayEquals(bookList.toArray(), bookDto.getBookList().toArray());
    }
}