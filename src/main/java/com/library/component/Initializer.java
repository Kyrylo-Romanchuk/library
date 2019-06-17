package com.library.component;

import com.library.data.dao.BookDao;
import com.library.data.model.Book;
import com.library.data.model.Language;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private final BookDao bookDao;

    public Initializer() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Kobzar", 1840, "Shevchenko", "There is a very bad book", Language.Ukraine));
        bookList.add(new Book("Lord of the rings", 1948, "Tolkien", "Lord of the rings, you should read this book", Language.English));
        bookList.add(new Book("Dark elf", 1988, "Salvatore", "Dark elf, this book about drou", Language.Russian));
        bookDao = new BookDao(bookList);
    }

    public BookDao getBookDao() {
        return bookDao;
    }
}
