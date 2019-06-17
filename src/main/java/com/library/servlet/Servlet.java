package com.library.servlet;

import com.library.component.Initializer;
import com.library.controller.BookLibraryController;
import com.sun.org.apache.xpath.internal.operations.Bool;

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

        getMapper.put("/books", bookLibraryController::showBookList);
        getMapper.put("/books/add", bookLibraryController::showAddNewBook);

        postMapper.put("/books/add", bookLibraryController::addNewBook);

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
        request.getSession().setAttribute("redirect", false);
        String requestURI = request.getRequestURI().replace(request.getContextPath() + "/library", "");
        String requestURL = mapper.get(requestURI).apply(request);
        if ((boolean) request.getSession().getAttribute("redirect")) {
            response.sendRedirect(request.getContextPath() + requestURL);
        } else {
            request.getRequestDispatcher(requestURL).forward(request, response);
        }
    }
}
