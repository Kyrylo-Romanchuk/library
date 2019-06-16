package com.library.component;

import com.library.data.dto.BookDto;
import com.library.data.model.Book;
import com.library.data.model.Language;

import java.util.Arrays;
import java.util.List;

public class Initializer {
    private final BookDto bookDto;

    public Initializer() {
        bookDto = new BookDto(Arrays.asList(
                new Book("Kobzar", 1840, "Shevchenko", "There is a very bad book", Language.Ukraine),
                new Book("Lord of the rings", 1948, "Tolkien", "Lord of the rings, you should read this book", Language.English),
                new Book("Dark elf", 1988, "Salvatore", "Dark elf, this book about drou", Language.Russian)
        ));
    }

    public BookDto getBookDto() {
        return bookDto;
    }
}
