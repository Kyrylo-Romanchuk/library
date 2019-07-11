package com.library.validator;

import com.library.data.model.Language;

public class LanguageValidator extends AbstractValidator<Language> {
    public LanguageValidator() {
        validations.add(new ValidationRegistry<Language, String>("name", Language::getName, ValidationUtility::isEmpty, "Please, enter the name"));
        validations.add(new ValidationRegistry<Language, String>("shortName", Language::getShortName, ValidationUtility::isEmpty, "Please, enter the short name"));
    }
}
