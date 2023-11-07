package main.homework.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Создайте TriangleAreaServlet, который при вводе трёх сторон выводит площадь.
//*если треугольник не получается – сообщить об ошибке

@WebServlet("/triangle")
public class Task2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            boolean isValid;
            Double a;
            Double b;
            Double c;
            PrintWriter pw = resp.getWriter();
            if (req.getParameter("a") == null || req.getParameter("b") == null || req.getParameter("c") == null) {
                isValid = false;
            } else {
                a = Double.valueOf(req.getParameter("a"));
                b = Double.valueOf(req.getParameter("b"));
                c = Double.valueOf(req.getParameter("c"));
                isValid = (!(a + b <= c)) && (!(a + c <= b)) && (!(b + c <= a));
            }
            if (isValid) {
                a = Double.valueOf(req.getParameter("a"));
                b = Double.valueOf(req.getParameter("b"));
                c = Double.valueOf(req.getParameter("c"));
                Double p = (a + b + c) / 2;
                pw.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
            } else {
                pw.println("invalid input");
            }
        } catch (Exception e) {
            PrintWriter pw = resp.getWriter();
            pw.println("invalid input!");
        }
    }
}
