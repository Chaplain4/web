package main.org.example.servlets;

import main.org.example.jdbc.impl.UserDAOImplDummy;
import main.org.example.model.User;
import main.org.example.util.EncryptDecryptUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activate")
public class ActivatorServlet extends HttpServlet {
    private UserDAOImplDummy dao = new UserDAOImplDummy();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Get token value
        String token = req.getParameter("token");
        // decrypt
        String email = EncryptDecryptUtils.decrypt(token);
        //2. Check if it's a valid email
        User userFromDB =  dao.findByEmail(email);
        if (userFromDB != null) {
            if (userFromDB.getIsActive()) {
                resp.getWriter().println("already active");
            } else {
                dao.activate(userFromDB);
                resp.getWriter().println("User activated");
            }
        } else {
            resp.getWriter().println("Incorrect user token");
        }
    }
}
