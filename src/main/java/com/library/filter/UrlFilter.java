package com.library.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class UrlFilter implements Filter {

    private final String[] values = {"/library/.*", "/", "/static/.*"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUri;

        requestUri = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath() + "", "");

        if (Arrays.stream(values).noneMatch(requestUri::matches)) {
            request.getRequestDispatcher("/library" + requestUri).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
