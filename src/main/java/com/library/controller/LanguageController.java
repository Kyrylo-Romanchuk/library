package com.library.controller;

import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.data.converter.IntegerConverter;
import com.library.data.converter.LanguageConverter;
import com.library.data.dao.LanguageDao;
import com.library.data.model.Language;
import com.library.validator.ValidationResult;
import com.library.validator.Validator;

import javax.servlet.http.HttpServletRequest;

public class LanguageController implements Controller {
    private final LanguageConverter languageConverter;
    private final LanguageDao languageDao;
    private final Validator<Language> languageValidator;
    private final IntegerConverter integerConverter;

    public LanguageController(LanguageDao languageDao, LanguageConverter languageConverter, IntegerConverter integerConverter, Validator<Language> languageValidator) {
        this.languageDao = languageDao;
        this.languageConverter = languageConverter;
        this.integerConverter = integerConverter;
        this.languageValidator = languageValidator;
    }

    @GetMapping("/languages")
    public String showLanguageList(HttpServletRequest request) {
        request.setAttribute("languages", languageDao.getAll());
        return "/languages/languagesList.jsp";
    }

    @GetMapping("/languages/add")
    public String showAddLanguage(HttpServletRequest request) {
        return "/languages/languageAdd.jsp";
    }

    @GetMapping("/languages/edit")
    public String bookEdit(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        request.setAttribute("language", languageDao.findById(id));
        return showAddLanguage(request);
    }

    @PostMapping("/languages/add")
    public String add(HttpServletRequest request) {
        Language language = languageConverter.convert(request);
        ValidationResult validationResult = languageValidator.validate(language);
        if (validationResult.isSuccess()) {
            languageDao.save(language);
            return "redirect:/languages";
        } else {
            request.setAttribute("validationResult", validationResult);
            request.setAttribute("language", language);
            return showAddLanguage(request);
            // TODO: 7/10/2019 redirect return "redirect:/languages/add";
        }
    }

    @PostMapping("/languages/delete")
    public String delete(HttpServletRequest request) {
        Integer id = integerConverter.convert(request.getParameter("id"));
        languageDao.delete(id);
        return showLanguageList(request);
    }
}
