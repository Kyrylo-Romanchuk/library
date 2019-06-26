package com.library.servlet;

import com.library.component.Initializer;
import com.library.component.annotation.GetMapping;
import com.library.component.annotation.PostMapping;
import com.library.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@WebServlet("/library/*")
public class Servlet extends HttpServlet {

    private Map<String, Function<HttpServletRequest, String>> getMapper = new HashMap<>();
    private Map<String, Function<HttpServletRequest, String>> postMapper = new HashMap<>();
    private Initializer initializer = new Initializer();

    @Override
    public void init() {
//        BookLibraryController bookLibraryController = initializer.getComponent(BookLibraryController.class);
//        AuthorController authorController = initializer.getComponent(AuthorController.class);
//
        List<Controller> controllers = initializer.getComponentList(Controller.class);

        fillGetMapper(controllers);
        fillPostMapper(controllers);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, getMapper);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doReference(request, response, postMapper);
    }

    private void doReference(HttpServletRequest request, HttpServletResponse response,
                             Map<String, Function<HttpServletRequest, String>> mapper) throws ServletException, IOException {
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

    private void fillGetMapper(List<Controller> controllers) {
        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getMethods();
            for (Method method : methods) {
                GetMapping annotation = method.getAnnotation(GetMapping.class);
                if (annotation != null) {
                    String url = annotation.value();
                    getMapper.put(url, invokeController(controller, method));
                }
            }
        }
    }

    private void fillPostMapper(List<Controller> controllers) {
        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getMethods();
            for (Method method : methods) {
                PostMapping annotation = method.getAnnotation(PostMapping.class);
                if (annotation != null) {
                    postMapper.put(annotation.value(), invokeController(controller, method));
                }
            }
        }
    }

    private Function<HttpServletRequest, String> invokeController(Object controller, Method method) {
        return request -> {
            try {
                return (String) method.invoke(controller, request);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
