package main.org.example.servlets;

import main.homework.DogDAOImpl;
import main.homework.model.Dog;
import main.org.example.util.HTMLTableBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static main.org.example.util.ServletUtils.forward;
import static main.org.example.util.ServletUtils.info;

//Создайте таблицу Dogs в MySQL БД. Определите поля, например ID, Возраст, Кличка, Порода, … Добавьте 5 собак.
// Создайте ViewDogServlet, который выводит все характеристики собаки по введенному ID
//*если пользователь ввел не существующую ID – сообщить что собака не найдена.
//*если пользователь не ввел ID – показать всех собак в виде HTML Table.
@WebServlet("/general")
public class GeneralUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward(req, resp, "/general"); //move forward with the same params and so on
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("Welcome, " + req.getParameter("name"));
        pw.println("<br>");
        DogDAOImpl ddi = new DogDAOImpl();
        Set<Dog> dogs = ddi.all();
        List<Dog> dogs1 = new ArrayList<>(dogs);
        HTMLTableBuilder htmlTableBuilder = new HTMLTableBuilder("all the dogs in db", true, dogs1.size(), 4, 5, 5, 5);
        htmlTableBuilder.addTableHeader("id", "age", "name", "breed");
        for (int i = dogs1.size(); i > 0; i--) {
            htmlTableBuilder.addRowValues(String.valueOf(dogs1.get(i - 1).getId()), String.valueOf(dogs1.get(i - 1).getAge()), dogs1.get(i - 1).getName(), dogs1.get(i - 1).getBreed());
        }
        String table = htmlTableBuilder.build();
        resp.setContentType("text/html");
        pw.println(table);
    }
}

