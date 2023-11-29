package main.org.example.filters;

import main.org.example.model.User;
import main.org.example.util.PropsUtils;
import main.org.example.util.ServletUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private PropsUtils props;
    private IOException ioException;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init Auth Filter");
        try {
            props = new PropsUtils("src/main/resources/ROLES_URL+PATTERNS_MAPPING.properties");
        } catch (IOException e) {
            ioException = e;
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (ioException != null) {
            ServletUtils.showError(req, resp, "Internal server error. Properties loading : " + ioException.getMessage());
        }

//        //1. Check if client request is valid
//        //can be direct image link, css link, etc.
//        ServletUtils.info((HttpServletRequest) servletRequest, "AuthFilter");
//        String path = ((HttpServletRequest) servletRequest).getServletPath();
//        if (path.contains(".")) {
//            ServletUtils.showError((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, "invalid request");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//        //pass forward

        //2 check for role
        User user = ServletUtils.getUserFromSession(req);
        if (user == null) {
            String path = req.getServletPath(); // employees
            if (props.getUrlPatterns("Unknown").contains(path)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ServletUtils.showError(req, resp, "please login");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy Auth Filter");
    }
}