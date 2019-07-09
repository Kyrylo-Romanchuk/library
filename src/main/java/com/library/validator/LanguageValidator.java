package com.library.validator;

import com.library.data.model.Language;

public class LanguageValidator implements Validator<Language>{
    @Override
    public ValidationResult validate(Language language) {
        ValidationResult validationResult = new ValidationResult();

        if (ValidationUtility.stringIsEmpty(language.getName())) {
            validationResult.add("name", "you must enter the language name");
        }

        if (ValidationUtility.stringIsEmpty(language.getShortName())) {
            validationResult.add("shortName", "you must enter short name");
        }
        return validationResult;
    }
}
