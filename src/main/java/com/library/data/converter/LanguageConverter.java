package com.library.data.converter;

import com.library.data.model.Language;

import javax.servlet.http.HttpServletRequest;

public class LanguageConverter implements Converter<HttpServletRequest, Language> {
    @Override
    public Language convert(HttpServletRequest request) {
        Language language = new Language();
        language.setName(request.getParameter("name"));
        language.setShortName(request.getParameter("shortName"));
        return language;
    }
}
