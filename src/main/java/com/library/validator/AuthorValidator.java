package com.library.validator;

import com.library.data.model.Author;

import java.util.Date;

public class AuthorValidator implements Validator<Author, ValidationResult> {
    @Override
    public ValidationResult validate(Author author) {
        ValidationResult validationResult = new ValidationResult();

        String firstName = author.getFirstName();
        if (stringIsEmpty(firstName) || !stringWithoutNumbers(firstName)) {
            validationResult.add("firstName", "please enter the first name");
        }

        String lastName = author.getLastName();
        if (stringIsEmpty(lastName) || !stringWithoutNumbers(lastName)) {
            validationResult.add("lastName", "please enter the last name");
        }

        if (stringIsEmpty(author.getBiography())) {
            validationResult.add("biography", "please enter the author biography");
        }

        Date birthDay = author.getBirthDay();
        if (objectIsEmpty(birthDay) || birthDay.after(new Date())) {
            validationResult.add("birthDay", "please enter author birthday");
        }
        return validationResult;
    }
}
