package com.library.controller;

import com.library.model.BookDto;
import com.library.model.BookProducer;
import com.library.model.Language;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private BookDto bookDto;

    public Initializer() {
        List<String> booksName = new ArrayList<>();
        booksName.add("Cobzar");
        booksName.add("Lord of the rings");
        booksName.add("Dark elf");

        List<Integer> booksYear = new ArrayList<>();
        booksYear.add(1840);
        booksYear.add(1948);
        booksYear.add(1988);

        List<String> booksAuthor = new ArrayList<>();
        booksAuthor.add("Cobzar");
        booksAuthor.add("Lord of the rings");
        booksAuthor.add("Dark elf");

        List<String> booksInfo = new ArrayList<>();
        booksInfo.add("There is a very bad book");
        booksInfo.add("Lord of the rings, you should read this book");
        booksInfo.add("Dark elf, this book about drou");

        List<Language> booksLanguage = new ArrayList<>();
        booksLanguage.add(Language.Ukraine);
        booksLanguage.add(Language.English);
        booksLanguage.add(Language.Russian);

        BookProducer bookProducer = new BookProducer(booksName, booksYear, booksAuthor, booksInfo, booksLanguage);
        this.bookDto = new BookDto(bookProducer);
    }

    public BookDto getBookDto() {
        return bookDto;
    }
}
