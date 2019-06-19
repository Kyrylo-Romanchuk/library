package com.library.component;

import com.library.controller.AuthorController;
import com.library.controller.BookLibraryController;
import com.library.data.converter.AuthorConverter;
import com.library.data.converter.BookConverter;
import com.library.data.converter.DateConverter;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.enums.Language;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private final BookLibraryController bookLibraryController;
    private final AuthorController authorController;

    public Initializer() {
        DateConverter dateConverter = new DateConverter();
        List<Author> authorList = new ArrayList<>();
        try {
            authorList.add(new Author(1, "Taras", "Shevchenko", "very bad author", dateConverter.convert("09/03/1814"), dateConverter.convert("10/03/1861")));
            authorList.add(new Author(2, "John Ronald Reuel", "Tolkien", "so good author", dateConverter.convert("03/01/1892"), dateConverter.convert("02/09/1973")));
            authorList.add(new Author(3, "Robert Anthony", "Salvatore", "dark elf", dateConverter.convert("20/01/1959"), dateConverter.convert("00/00/0000")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AuthorDao authorDao = new AuthorDao(authorList);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Kobzar", 1840, authorDao.findAuthorById(1), "There is a very bad book", Language.Ukraine));
        bookList.add(new Book("Lord of the rings", 1948, authorDao.findAuthorById(2), "Lord of the rings, you should read this book", Language.English));
        bookList.add(new Book("Dark elf", 1988, authorDao.findAuthorById(3), "Dark elf, this book about drou", Language.Russian));
        BookDao bookDao = new BookDao(bookList);

        bookLibraryController = new BookLibraryController(bookDao, authorDao,new BookConverter(authorDao));
        authorController = new AuthorController(authorDao, new AuthorConverter());
    }

    public BookLibraryController getBookLibraryController() {
        return bookLibraryController;
    }

    public AuthorController getAuthorController() {
        return authorController;
    }
}
