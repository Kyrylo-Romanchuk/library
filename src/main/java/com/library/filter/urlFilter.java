package com.library.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class urlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUri = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath() + "", "");
//        request.getRequestURI().replace( + "/library", "");

        if (!requestUri.matches(".*/library/.*") && !requestUri.matches("/")) {
            request.getRequestDispatcher("/library" + requestUri).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
