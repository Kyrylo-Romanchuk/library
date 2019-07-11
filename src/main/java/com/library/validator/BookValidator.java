package com.library.validator;

import com.library.data.model.Author;
import com.library.data.model.Book;
import com.library.data.model.Language;

public class BookValidator extends AbstractValidator<Book> {
    public BookValidator() {
        validations.add(new ValidationRegistry<Book, String>("name", Book::getName, ValidationUtility::isEmpty, "Please, enter the name"));
        validations.add(new ValidationRegistry<Book, String>("info", Book::getInfo, ValidationUtility::isEmpty, "Please, enter the info"));
        validations.add(new ValidationRegistry<Book, Integer>("year", Book::getYear, ValidationUtility::isEmpty, "Entered year is not correct (format: 'yyyy')"));
        validations.add(new ValidationRegistry<Book, Author>("info", Book::getAuthor, ValidationUtility::isEmpty, "Please, choose the author"));
        validations.add(new ValidationRegistry<Book, Language>("info", Book::getLanguage, ValidationUtility::isEmpty, "Please, choose the language"));
    }
}
