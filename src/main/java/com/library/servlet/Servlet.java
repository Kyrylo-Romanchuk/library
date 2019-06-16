package com.library.servlet;

import com.library.component.Initializer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Servlet extends HttpServlet {

    private Map<String, String> getMapper = new HashMap<>();
    private Initializer initializer;

    @Override
    public void init() throws ServletException {
        this.initializer = new Initializer();

        this.getMapper.put("/bookLibraryTest", "WEB-INF/library.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, getMapper);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void doReference(HttpServletRequest request, HttpServletResponse response, Map<String, String> mapper) throws ServletException, IOException {
        String requestURI = request.getRequestURI().replace(request.getContextPath() + "/library", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(mapper.get(requestURI));
        request.setAttribute("books", initializer.getBookDto().getBookList());
        requestDispatcher.forward(request, response);
    }
}
