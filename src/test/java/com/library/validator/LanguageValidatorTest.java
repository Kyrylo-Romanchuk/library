package com.library.validator;

import com.library.data.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LanguageValidatorTest {

    @Mock
    private Language language;

    @Test
    public void validate() {
        LanguageValidator languageValidator = new LanguageValidator();
        when(language.getName()).thenReturn("test");
        when(language.getShortName()).thenReturn("ts");

        assertEquals(0, languageValidator.validate(language).getResultMap().size());
    }
}