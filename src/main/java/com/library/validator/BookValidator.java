package com.library.validator;

import com.library.data.model.Book;

public class BookValidator implements Validator<Book, ValidationResult> {
    @Override
    public ValidationResult validate(Book book) {
        ValidationResult validationResult = new ValidationResult();

        if (stringIsEmpty(book.getName())) {
            validationResult.add("name", "you must enter the book name");
        }

        if (stringIsEmpty(book.getInfo())) {
            validationResult.add("info", "you must enter the book info");
        }

        if (integerIsEmpty(book.getYear())) {
            validationResult.add("year", "entered year is not correct (format: 'yyyy') ");
        }

        if (objectIsEmpty(book.getAuthor())) {
            validationResult.add("author", "please choose the book author");
        }

        if (objectIsEmpty(book.getLanguage())) {
            validationResult.add("name", "please choose the book language");
        }
        return validationResult;
    }
}
