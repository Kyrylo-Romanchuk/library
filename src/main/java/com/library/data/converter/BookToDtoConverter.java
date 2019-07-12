package com.library.data.converter;

import com.library.data.dto.BookDto;
import com.library.data.model.Book;

public class BookToDtoConverter implements Converter<Book, BookDto> {
    private final AuthorToDtoConverter authorToDtoConverter;

    public BookToDtoConverter(AuthorToDtoConverter authorToDtoConverter) {
        this.authorToDtoConverter = authorToDtoConverter;
    }

    @Override
    public BookDto convert(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setGenres(book.getGenres());
        bookDto.setName(book.getName());
        bookDto.setYear(book.getYear());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setInfo(book.getInfo());
        bookDto.setAuthor(authorToDtoConverter.convert(book.getAuthor()));
        return bookDto;
    }
}
