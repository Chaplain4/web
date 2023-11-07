package main.homework.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//Создайте RandomServlet, который выводит на экран случайное число от 0 до 1000. Формат клиентского запроса: /random
//*реализуйте обработку параметров. запроса: /random?min={1}&max={2}
//Например, /random?min=1&max=10 должен вывести число от 1 до 10.
//*если пользователь ввел не корректно границы – сообщить об ошибке.
//*если пользователь ввел только максимальную границу – генерировать число от 0 до max

@WebServlet("/random")
public class Task1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            boolean isValid = true;
            Integer max;
            Integer min;
            if (req.getParameter("min") == null || req.getParameter("min").equals("")) {
                min = 0;
            } else min = Integer.valueOf(req.getParameter("min"));
            if (req.getParameter("max") == null || req.getParameter("max").equals("")) {
                isValid = false;
                max = 0;
            } else max = Integer.valueOf(req.getParameter("max"));
            if (min >= max) {
                isValid = false;
            }
            PrintWriter pw = resp.getWriter();
            if (isValid) {
                pw.println((int) ((Math.random() * (max - min + 1)) + min));
            } else {
                pw.println("invalid input");
            }
        } catch (Exception e) {
            PrintWriter pw = resp.getWriter();
            pw.println("invalid input!");
        }
    }
}