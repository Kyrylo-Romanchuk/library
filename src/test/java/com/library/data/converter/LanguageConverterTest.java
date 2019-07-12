package com.library.data.converter;

import com.library.data.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LanguageConverterTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private IntegerConverter integerConverter;

    @InjectMocks
    private LanguageConverter languageConverter;

    @Test
    public void convert() {
        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("shortName")).thenReturn("ts");

        Language language = languageConverter.convert(request);

        assertEquals("test", language.getName());
        assertEquals("ts", language.getShortName());
    }
}