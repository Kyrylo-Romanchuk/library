package com.library.data.converter;

import com.library.data.dto.AuthorDto;
import com.library.data.model.Author;

public class AuthorToDtoConverter implements Converter<Author, AuthorDto> {
    @Override
    public AuthorDto convert(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setBiography(author.getBiography());
        authorDto.setBirthDay(author.getBirthDay());
        authorDto.setDieDay(author.getDieDay());
        authorDto.setFullName(String.format("%s %s", author.getFirstName(), author.getLastName()));
        return authorDto;
    }
}
