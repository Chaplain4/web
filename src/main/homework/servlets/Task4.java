package main.homework.servlets;

import main.homework.DogDAO;
import main.homework.DogDAOImpl;
import main.homework.model.Dog;
import main.org.example.util.DBUtils;
import main.org.example.util.HTMLTableBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static main.org.example.util.ServletUtils.info;

//Создайте таблицу Dogs в MySQL БД. Определите поля, например ID, Возраст, Кличка, Порода, … Добавьте 5 собак.
// Создайте ViewDogServlet, который выводит все характеристики собаки по введенному ID
//*если пользователь ввел не существующую ID – сообщить что собака не найдена.
//*если пользователь не ввел ID – показать всех собак в виде HTML Table.
@WebServlet("/dog")
public class Task4 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        info(req, "dog -> doGet()");
        RequestDispatcher rd = req.getRequestDispatcher("/dogs.html");
        rd.forward(req, resp); //move forward with the same params and so on
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        DogDAOImpl ddi = new DogDAOImpl();
        info(req, "dog -> doPost()");
        if (req.getParameter("dog-id") == null || req.getParameter("dog-id").equals("")) {
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
        } else {
            int id = Integer.parseInt(req.getParameter("dog-id"));
            if (ddi.findById(id) != null){
                pw.println(ddi.findById(id).toString());
            } else
                pw.println("No dog found");
        }
    }
}

