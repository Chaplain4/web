package main.org.example.filters;

import main.org.example.util.ServletUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebFilter(urlPatterns = {"/img/*", "/css/*", "/js/*"})
public class ResourceFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init Resource Filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = req.getServletPath();
        File rootFile = new File("C:\\Users\\st\\Documents\\web1\\src\\main\\webapp" + path);
        if (!rootFile.exists()) {
            System.out.println("Invalid file path");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy Logger Filter");
    }
}
