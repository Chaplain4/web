package main.org.example.servlets;


import main.org.example.jdbc.impl.UserDAOImpl;
import main.org.example.model.User;
import main.org.example.util.EncryptDecryptUtils;
import main.org.example.util.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static main.org.example.util.ServletUtils.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAOImpl dao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        forward(req, resp, "/login.html");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1st get params
        String email = req.getParameter("email");
        String password = EncryptDecryptUtils.encrypt(req.getParameter("password"));

        // 2nd validation

        //3rd check user
        User user = dao.findByEmail(email.trim());
        if (user != null) {
            // user exists
            if (!user.getPwd().equals(password)) {
                ServletUtils.include(req, resp, "/login.html", "Sorry, wrong password! Try again or <a href='repair'>repair your account</a>");
                return; // ?
            }
            if (!user.getIsActive()) {
                ServletUtils.include(req, resp, "/login.html", "Sorry, you are not activated yet! Please check you email or <a href='activate'>activate your account</a>");
                return; // ?
            }
            // User exists and active.
            //return current Session or new Session with 30 min timeout by default
            //Saving user object into session
            ServletUtils.saveUserInSession(req, user);
            forward(req, resp, "/employees"); // forward to servlet
        } else {
            ServletUtils.include(req, resp, "/login.html", "Sorry, you are not activated yet! Please check you email or <a href='activate'>activate your account</a>");
        }
    }
}
