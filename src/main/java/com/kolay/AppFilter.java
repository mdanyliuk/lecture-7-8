package com.kolay;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class AppFilter implements Filter {

    private static final List<String> loginRequiredPages = List.of("/welcome", "/users");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = req.getServletPath();

        if (!loginRequiredPages.contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = req.getSession();
        boolean isLoggedIn = (session != null) && (session.getAttribute("user") != null);

        if (isLoggedIn) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
