package com.library.controller;

import com.library.data.converter.LanguageConverter;
import com.library.data.dao.LanguageDao;
import com.library.data.model.Language;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LanguageControllerTest {

    @Mock
    private Language language;

    @Mock
    private LanguageDao languageDao;

    @Mock
    private LanguageConverter languageConverter;

    @Mock
    private Validator<Language> languageValidator;

    @Mock
    private HttpServletRequest request;

    @Mock
    List<Language> languagesList;

    @Mock
    private ValidationResult validationResult;

    @InjectMocks
    private LanguageController languageController;

    @Test
    public void showLanguageList() {
        when(languageDao.getAll()).thenReturn(languagesList);
        assertEquals("/languages/languagesList.jsp", languageController.showLanguageList(request));
        verify(request).setAttribute("languages", languagesList);
    }

    @Test
    public void showAddLanguage() {
        assertEquals("/languages/languageAdd.jsp", languageController.showAddLanguage(request));
    }

    @Test
    public void add() {
        when(languageConverter.convert(request)).thenReturn(language);
        when(languageValidator.validate(language)).thenReturn(validationResult);
        assertEquals("redirect:/languages", languageController.add(request));
        verify(languageDao).add(language);
    }
}