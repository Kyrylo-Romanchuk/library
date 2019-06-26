package com.library.component;

import com.library.controller.AuthorController;
import com.library.controller.BookLibraryController;
import com.library.controller.Controller;
import com.library.data.converter.*;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.Language;
import com.library.validator.AuthorValidator;
import com.library.validator.BookValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initializer {
    private final Map<Class, Controller> componentMap = new HashMap<>();

    public Initializer() {
        DateConverter dateConverter = new DateConverter();
        IntegerConverter integerConverter = new IntegerConverter();
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(1, "Taras", "Shevchenko", "very bad author", dateConverter.convert("03/09/1814"), dateConverter.convert("03/10/1861")));
        authorList.add(new Author(2, "John Ronald Reuel", "Tolkien", "so good author", dateConverter.convert("01/03/1892"), dateConverter.convert("09/02/1973")));
        authorList.add(new Author(3, "Robert Anthony", "Salvatore", "dark elf", dateConverter.convert("01/20/1959"), dateConverter.convert(null)));

        AuthorDao authorDao = new AuthorDao(authorList);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Kobzar", 1840, authorDao.findById(1), "There is a very bad book", Language.Ukraine));
        bookList.add(new Book(2, "Lord of the rings", 1948, authorDao.findById(2), "Lord of the rings, you should read this book", Language.English));
        bookList.add(new Book(3, "Dark elf", 1988, authorDao.findById(3), "Dark elf, this book about drou", Language.Russian));
        BookDao bookDao = new BookDao(bookList);

        BookLibraryController bookLibraryController = new BookLibraryController(bookDao, authorDao, new BookConverter(authorDao, integerConverter), new BookValidator());
        AuthorController authorController = new AuthorController(authorDao, new AuthorConverter(dateConverter), new AuthorValidator(), new AuthorToDtoConverter());

        componentMap.put(bookLibraryController.getClass(), bookLibraryController);
        componentMap.put(authorController.getClass(), authorController);
    }

    public <T> T getComponent(Class<T> type) {
        return (T) componentMap.get(type);
    }

    public <T> List<T> getComponentList(Class<T> type) {
        List<T> componentList = new ArrayList<>();
        for (Object component : componentMap.values()) {
            if (type.isInstance(component)) {
                componentList.add((T) component);
            }
        }
        return componentList;
    }
}
