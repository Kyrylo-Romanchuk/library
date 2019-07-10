package com.library.validator;

import com.library.data.model.Author;

import java.util.Date;

public class AuthorValidator implements Validator<Author> {
    @Override
    public ValidationResult validate(Author author) {
        ValidationResult validationResult = new ValidationResult();

        String firstName = author.getFirstName();
        if (ValidationUtility.stringIsEmpty(firstName) || ValidationUtility.stringNotOnlyLetters(firstName)) {
            validationResult.add("firstName", "please enter the first name");
        }

        String lastName = author.getLastName();
        if (ValidationUtility.stringIsEmpty(lastName) || ValidationUtility.stringNotOnlyLetters(lastName)) {
            validationResult.add("lastName", "please enter the last name");
        }

        if (ValidationUtility.stringIsEmpty(author.getBiography())) {
            validationResult.add("biography", "please enter the author biography");
        }

        Date birthDay = author.getBirthDay();
        if (ValidationUtility.objectIsEmpty(birthDay) || birthDay.after(new Date())) {
            validationResult.add("birthDay", "please enter author birthday");
        }
        return validationResult;
    }
}
