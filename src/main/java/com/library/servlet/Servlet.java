package com.library.servlet;

import com.library.component.Initializer;
import com.library.controller.AuthorController;
import com.library.controller.BookLibraryController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@WebServlet("/library/*")
public class Servlet extends HttpServlet {

    private Map<String, Function<HttpServletRequest, String>> getMapper = new HashMap<>();
    private Map<String, Function<HttpServletRequest, String>> postMapper = new HashMap<>();
    private Initializer initializer = new Initializer();

    @Override
    public void init() throws ServletException {

        BookLibraryController bookLibraryController = initializer.getBookLibraryController();
        AuthorController authorController = initializer.getAuthorController();

        getMapper.put("/books", bookLibraryController::showBookList);
        getMapper.put("/books/add", bookLibraryController::showAddNewBook);
        getMapper.put("/authors", authorController::showAuthorList);
        getMapper.put("/authors/add", authorController::showAddAuthor);

        postMapper.put("/books/add", bookLibraryController::addNewBook);
        postMapper.put("/authors/add", authorController::addAuthor);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, getMapper);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, postMapper);
    }

    private void doReference(HttpServletRequest request, HttpServletResponse response, Map<String, Function<HttpServletRequest, String>> mapper) throws ServletException, IOException {
        String requestURI = request.getRequestURI().replace(request.getContextPath() + "/library", "");
        if (mapper.containsKey(requestURI)) {
            String targetURL = mapper.get(requestURI).apply(request);
            if (targetURL.endsWith(".jsp")) {
                targetURL = "/WEB-INF/jsp" + targetURL;
            }
            if (targetURL.startsWith("redirect:")) {
                response.sendRedirect(request.getContextPath() + targetURL.substring(9));
            } else {
                request.getRequestDispatcher(targetURL).forward(request, response);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
