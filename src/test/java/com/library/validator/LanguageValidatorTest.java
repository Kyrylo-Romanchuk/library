package com.library.validator;

import com.library.data.model.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LanguageValidatorTest {

    private Language language;

    @Before
    public void init() {
        language = new Language();
        language.setName("test");
        language.setShortName("ts");
    }

    @Test
    public void validate() {
        LanguageValidator languageValidator = new LanguageValidator();

        assertTrue(languageValidator.validate(language).isSuccess());
    }
}