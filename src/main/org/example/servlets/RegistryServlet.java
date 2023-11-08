package main.org.example.servlets;

import main.org.example.jdbc.impl.UserDAOImpl;
import main.org.example.model.User;
import main.org.example.util.EmailUtils;
import main.org.example.util.EncryptDecryptUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registry")
public class RegistryServlet extends HttpServlet {
    private UserDAOImpl dao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/reg.html");
        rd.forward(req, resp); //move forward with the same params and so on
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getting parameters from HTML Reg form
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String psw1 = req.getParameter("psw1");
        String psw2 = req.getParameter("psw2");

        //1st Validation
        boolean isValid = true;
        if (!psw1.equals(psw2) || !email.contains("@") || name.isEmpty() || psw1.isEmpty()) {
            isValid = false;
        }
        String token = EncryptDecryptUtils.encrypt(email);
        String url = "http://localhost:8080/web_app_war/activate?token="+token;
        if (isValid) {
            User userFromGUI = new User();
            userFromGUI.setName(name.trim());
            userFromGUI.setEmail(email.trim());
            userFromGUI.setPwd(EncryptDecryptUtils.encrypt(psw1));
            dao.create(userFromGUI);
        }

        //2nd Send message with activate instructions
        if (isValid) {
            EmailUtils.send(email, "Finish your registry", "Follow link "+url);
        }


        //3rd show some info
        PrintWriter pw2 = resp.getWriter();
        pw2.println("Check email");
    }
}
