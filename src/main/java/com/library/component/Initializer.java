package com.library.component;

import com.library.data.dto.BookDto;

public class Initializer {
    private final BookDto bookDto;

    public Initializer() {
        bookDto = new BookDto();
    }

    public BookDto getBookDto() {
        return bookDto;
    }
}
