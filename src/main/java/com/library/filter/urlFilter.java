package com.library.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class urlFilter implements Filter {

    private final String[] values = {".*/library/.*", "/"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUri = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath() + "", "");

        if (!Arrays.stream(values).anyMatch(requestUri::equals)) {
            request.getRequestDispatcher("/library" + requestUri).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
