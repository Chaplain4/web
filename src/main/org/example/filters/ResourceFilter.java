package main.org.example.filters;

import main.org.example.util.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = {"/img/*", "/css/*", "/js/*"})
public class ResourceFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init Resource Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
//        File rootFile = new File(path); //C:\Users\st\Documents\web1\src\main\webapp\img\404.png
//        String path = req.getServletPath();
//        if (!rootFile.exists()) {
//            System.out.println("Invalid file path");
//            return;
//        }

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            ServletUtils.forward(req, resp, "img/404.png");
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy Logger Filter");
    }
}
