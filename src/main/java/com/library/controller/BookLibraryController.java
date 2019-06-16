package com.library.controller;

import com.library.data.dto.BookDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class BookLibraryController {
    private final BookDto bookDto;

    public BookLibraryController(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public String getUrl(HttpServletRequest request){
        request.setAttribute("books", bookDto.getBookList());
        return "/WEB-INF/library.jsp";
    }
}
