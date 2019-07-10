package com.library.component;

import com.library.controller.AuthorController;
import com.library.controller.BookLibraryController;
import com.library.controller.GenreController;
import com.library.controller.LanguageController;
import com.library.data.converter.*;
import com.library.data.dao.AuthorDao;
import com.library.data.dao.BookDao;
import com.library.data.dao.GenreDao;
import com.library.data.dao.LanguageDao;
import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.Genre;
import com.library.data.model.Language;
import com.library.validator.AuthorValidator;
import com.library.validator.BookValidator;
import com.library.validator.GenreValidator;
import com.library.validator.LanguageValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Initializer {
    private final Map<Class, Object> componentMap = new HashMap<>();

    public Initializer() {
        DateConverter dateConverter = new DateConverter();
        IntegerConverter integerConverter = new IntegerConverter();
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(1, "Taras", "Shevchenko", "very bad author", dateConverter.convert("03/09/1814"), dateConverter.convert("03/10/1861")));
        authorList.add(new Author(2, "John Ronald Reuel", "Tolkien", "so good author", dateConverter.convert("01/03/1892"), dateConverter.convert("09/02/1973")));
        authorList.add(new Author(3, "Robert Anthony", "Salvatore", "dark elf", dateConverter.convert("01/20/1959"), dateConverter.convert(null)));

        AuthorDao authorDao = new AuthorDao(authorList);

        List<Language> languages = new ArrayList<>();
        languages.add(new Language(1, "Ukraine", "uk"));
        languages.add(new Language(2, "Russian", "ru"));
        languages.add(new Language(3, "English", "en"));

        LanguageDao languageDao = new LanguageDao(languages);

        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(1, "Classic"));
        genres.add(new Genre(2, "Drama"));
        genres.add(new Genre(3, "Fantasy"));
        GenreDao genreDao = new GenreDao(genres);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "Kobzar", 1840, authorDao.findById(1), "There is a very bad book", languageDao.findById(1), genres));
        bookList.add(new Book(2, "Lord of the rings", 1948, authorDao.findById(2), "Lord of the rings, you should read this book", languageDao.findById(3), genres));
        bookList.add(new Book(3, "Dark elf", 1988, authorDao.findById(3), "Dark elf, this book about drou", languageDao.findById(2), genres));
        BookDao bookDao = new BookDao(bookList);

        BookConverter bookConverter = new BookConverter(authorDao, languageDao, genreDao, integerConverter);
        BookLibraryController bookLibraryController = new BookLibraryController(bookDao, authorDao, languageDao, genreDao, bookConverter, new AuthorToDtoConverter(), new BookValidator());
        AuthorController authorController = new AuthorController(authorDao, new AuthorConverter(dateConverter), new AuthorValidator(), new AuthorToDtoConverter());
        LanguageController languageController = new LanguageController(languageDao, new LanguageConverter(), new LanguageValidator());
        GenreController genreController = new GenreController(genreDao, new GenreConverter(), new GenreValidator());

        componentMap.put(bookLibraryController.getClass(), bookLibraryController);
        componentMap.put(authorController.getClass(), authorController);
        componentMap.put(languageController.getClass(), languageController);
        componentMap.put(genreController.getClass(), genreController);
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
