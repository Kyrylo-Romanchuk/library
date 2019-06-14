package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class BookProducer {
    private List<Book> books = new ArrayList<>();

    public BookProducer(List<String> bookNames, List<Integer> bookYear, List<String> bookAuthor, List<String> bookInfo, List<Language> languages) {
        createBookList(bookNames, bookYear, bookAuthor, bookInfo, languages);
    }

    public List<Book> getBookList() {
        return books;
    }

    private void createBookList(List<String> bookNames, List<Integer> bookYear, List<String> bookAuthor, List<String> bookInfo, List<Language> languages) {
        for (int i = 0; i < bookNames.size(); i++) {
            Book book = new Book(bookNames.get(i), bookYear.get(i), bookAuthor.get(i), languages.get(i));
            book.setBookInfo(bookInfo.get(i));
            books.add(book);
        }
    }
}
