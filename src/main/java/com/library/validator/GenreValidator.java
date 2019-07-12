package com.library.validator;

import com.library.data.model.Genre;

public class GenreValidator extends AbstractValidator<Genre> {
    public GenreValidator() {
        validations.add(new ValidationRegistry<Genre, String>("name", Genre::getName, ValidationUtility::isValid, "Please, enter the name"));
    }
}
