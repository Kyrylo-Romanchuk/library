package com.library.data.dto;

import com.library.data.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

public class BookDtoTest {

    @Mock
    List<Book> bookList;

    @InjectMocks
    BookDto bookDto = new BookDto(bookList);

    @Test
    public void getBookList() {
        assertEquals(bookDto.getBookList(), bookList);
    }
}