package com.library.data.converter;

import com.library.data.model.Language;

import javax.servlet.http.HttpServletRequest;

public class LanguageConverter implements Converter<HttpServletRequest, Language> {
    private final IntegerConverter integerConverter;

    public LanguageConverter(IntegerConverter integerConverter) {
        this.integerConverter = integerConverter;
    }

    @Override
    public Language convert(HttpServletRequest request) {
        Language language = new Language();
        language.setId(integerConverter.convert(request.getParameter("id")));
        language.setName(request.getParameter("name"));
        language.setShortName(request.getParameter("shortName"));
        return language;
    }
}
