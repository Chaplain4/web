package main.org.example.servlets;

import main.org.example.jdbc.impl.UserDAOImpl;
import main.org.example.model.User;
import main.org.example.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static main.org.example.util.ServletUtils.forward;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {
    private UserDAOImpl dao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        forward(req, resp, "/reset.html");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        User user = dao.findByEmail(email.trim());
        if (user == null) {
            ServletUtils.include(req, resp, "/reset.html", "Sorry, wrong email! Try again");
        } else if (!user.getIsActive()) {
            ServletUtils.include(req, resp, "/login.html", "Sorry, you are not activated yet! Please check you email or <a href='activate'>activate your account</a>");
        } else {
            String newPwd = PasswordGeneratorUtils.generatePassword();
            user.setPwd(EncryptDecryptUtils.encrypt(newPwd));
            dao.update(user);
            EmailUtils.send(email, "YOUR NEW PWD", newPwd);
            PrintWriter pw = resp.getWriter();
            pw.println("check your email please, then <a href='login'>try to login again</a>");
        }
    }
}
