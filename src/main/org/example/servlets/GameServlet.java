package main.org.example.servlets;

import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.openJSP(req, resp, "game");
        ServletUtils.forward(req, resp, "game");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer max;
        Integer min;
        if (req.getParameter("numA") == null || req.getParameter("numA").equals("")) {
            String result = "No min input";
            req.setAttribute("result", result);
            ServletUtils.openJSP(req, resp, "result");
            return;
        } else min = Integer.valueOf(req.getParameter("numA"));
        if (req.getParameter("numB") == null || req.getParameter("numB").equals("")) {
            String result = "No max input";
            req.setAttribute("result", result);
            ServletUtils.openJSP(req, resp, "result");
            return;
        } else max = Integer.valueOf(req.getParameter("numB"));
        if (min > max) {
            String result = "min > max";
            req.setAttribute("result", result);
            ServletUtils.openJSP(req, resp, "result");
        } else {
            String result = String.valueOf((int) ((Math.random() * (max - min + 1)) + min));
            req.setAttribute("result", result);
            ServletUtils.openJSP(req, resp, "result");
        }
    }
}
