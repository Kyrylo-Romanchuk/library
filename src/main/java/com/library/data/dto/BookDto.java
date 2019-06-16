package com.library.data.dto;

import com.library.data.model.Book;
import com.library.data.model.Language;

import java.util.Arrays;
import java.util.List;

public class BookDto {
    private List<Book> books;

    public BookDto() {
        this.books = Arrays.asList(
                new Book("Kobzar", 1840, "Shevchenko", "There is a very bad book", Language.Ukraine),
                new Book("Lord of the rings", 1948, "Tolkien", "Lord of the rings, you should read this book", Language.English),
                new Book("Dark elf", 1988, "Salvatore", "Dark elf, this book about drou", Language.Russian)
        );
    }

    public List<Book> getBookList() {
        return books;
    }
}
