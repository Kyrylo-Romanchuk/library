package com.library.data.converter;

import com.library.data.dao.AuthorDao;
import com.library.data.dao.GenreDao;
import com.library.data.dao.LanguageDao;
import com.library.data.model.Book;
import com.library.data.model.Genre;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookConverter implements Converter<HttpServletRequest, Book> {
    private final AuthorDao authorDao;
    private final LanguageDao languageDao;
    private final GenreDao genreDao;
    private final IntegerConverter integerConverter;

    public BookConverter(AuthorDao authorDao, LanguageDao languageDao, GenreDao genreDao,
                         IntegerConverter integerConverter) {
        this.authorDao = authorDao;
        this.languageDao = languageDao;
        this.genreDao = genreDao;
        this.integerConverter = integerConverter;
    }

    @Override
    public Book convert(HttpServletRequest request) {
        Book book = new Book();
        book.setId(integerConverter.convert(request.getParameter("id")));
        book.setName(request.getParameter("bookName"));
        book.setYear(integerConverter.convert(request.getParameter("bookYear")));
        Integer id = integerConverter.convert(request.getParameter("bookAuthor"));
        book.setAuthor(authorDao.findById(id));
        book.setInfo(request.getParameter("bookInfo"));
        Integer languageId = integerConverter.convert(request.getParameter("bookLanguage"));
        book.setLanguage(languageDao.findById(languageId));
        String[] genresId = request.getParameterValues("genres");
        if (genresId != null) {
            List<Genre> genreList = Arrays.stream(genresId)
                    .map(integerConverter::convert)
                    .map(genreDao::findById)
                    .collect(Collectors.toList());
            book.setGenres(genreList);
        }
        return book;
    }
}
