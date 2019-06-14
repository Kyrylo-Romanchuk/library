package com.library.model;

import java.util.List;

public class BookDto {
    private BookProducer bookProducer;

    public BookDto(BookProducer bookProducer) {
        this.bookProducer = bookProducer;
    }

    public List<Book> getBookList (){
        return bookProducer.getBookList();
    }
}
