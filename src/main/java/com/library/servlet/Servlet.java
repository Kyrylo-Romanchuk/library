package com.library.servlet;

import com.library.component.Initializer;
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
    private Initializer initializer = new Initializer();

    @Override
    public void init() throws ServletException {
        this.getMapper.put("/books", new BookLibraryController(initializer.getBookDto())::getUrl);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, getMapper);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void doReference(HttpServletRequest request, HttpServletResponse response, Map<String, Function<HttpServletRequest, String>> mapper) throws ServletException, IOException {
        String requestURL = request.getRequestURI().replace(request.getContextPath() + "/library", "");
        request.getRequestDispatcher(mapper.get(requestURL).apply(request)).forward(request, response);
    }
}
