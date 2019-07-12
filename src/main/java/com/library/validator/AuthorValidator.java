package com.library.validator;

import com.library.data.model.Author;

import java.util.Date;

public class AuthorValidator extends AbstractValidator<Author> {
    public AuthorValidator() {
        validations.add(new ValidationRegistry<Author, String>("firstName", Author::getFirstName, ValidationUtility::isValid, "please enter the first name"));
        validations.add(new ValidationRegistry<Author, String>("firstName", Author::getFirstName, ValidationUtility::stringOnlyWords, "first name should contain letters only"));
        validations.add(new ValidationRegistry<Author, String>("lastName", Author::getLastName, ValidationUtility::isValid, "please enter the last name"));
        validations.add(new ValidationRegistry<Author, String>("lastName", Author::getLastName, ValidationUtility::stringOnlyWords, "last name should contain letters only"));
        validations.add(new ValidationRegistry<Author, String>("biography", Author::getBiography, ValidationUtility::isValid, "please enter the author biography"));
        validations.add(new ValidationRegistry<Author, Date>("birthDay", Author::getBirthDay, ValidationUtility::isValid, "please enter author birthday"));
    }
}
