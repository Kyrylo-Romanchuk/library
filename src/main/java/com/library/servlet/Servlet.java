package com.library.servlet;

import com.library.controller.Initializer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class Servlet extends HttpServlet {

    private HashMap<String, String> getMaper = new HashMap<>();
    private Initializer initializer;

    @Override
    public void init() throws ServletException {
        this.initializer = new Initializer();

        this.getMaper.put("/bookLibrary", "WEB-INF/library.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, getMaper);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void doReference(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> Maper) throws ServletException, IOException {
        String requestURI = request.getRequestURI().replace(request.getContextPath() + "/library", "");

        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Maper.get(requestURI));
            request.setAttribute("books", initializer.getBookDto().getBookList());
            requestDispatcher.forward(request, response);
        } catch (java.lang.Exception e) {
        }
    }
}
