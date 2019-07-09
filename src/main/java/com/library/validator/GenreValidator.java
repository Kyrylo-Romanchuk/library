package com.library.validator;

import com.library.data.model.Genre;

public class GenreValidator implements Validator<Genre> {

    @Override
    public ValidationResult validate(Genre genre) {
        ValidationResult validationResult = new ValidationResult();
        if (ValidationUtility.stringIsEmpty(genre.getName())) {
            validationResult.add("name", "you must enter the name");
        }
        return validationResult;
    }
}
