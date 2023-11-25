package main.org.example.servlets;

import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 st Check if user logged in session at all
        HttpSession session = req.getSession();
        if (session.getAttribute("logged_user") == null) {
            System.out.println("can't logout");
            ServletUtils.forward(req, resp, "/login.html");
        } else {
            System.out.println("Logout of session # " + session.getId() + "successful!");
            session.invalidate();
            req.setAttribute("msg", "Logout successful!");
            ServletUtils.openJSP(req, resp, "generic-message");
        }
    }
}
