package com.library.data.dao;

import com.library.data.model.Language;

import java.util.List;

public class LanguageDao implements CommonDao<Language> {
    private List<Language> languages;

    public LanguageDao(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public void add(Language language) {
        if (language.getId() == null) {
            Integer maxId = languages.stream().map(Language::getId).max(Integer::compareTo).orElse(0);
            language.setId(maxId + 1);
        }
        languages.add(language);
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language findById(Integer id) {
        return languages.stream().filter(language_new -> language_new.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        languages.remove(findById(id));
    }

    @Override
    public void save(Language language) {
        Language foundLanguage = findById(language.getId());
        if (foundLanguage != null) {
            delete(foundLanguage.getId());
        }
        languages.add(language);
    }
}
