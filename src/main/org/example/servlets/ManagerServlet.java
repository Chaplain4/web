package main.org.example.servlets;

import main.homework.DogDAOImpl;
import main.homework.model.Dog;
import main.org.example.util.HTMLTableBuilder;
import main.org.example.util.IOUtils;

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

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward(req, resp, "/manager.html"); //move forward with the same params and so on
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DogDAOImpl ddi = new DogDAOImpl();
        Set<Dog> dogs = ddi.all();
        List<Dog> dogs1 = new ArrayList<>(dogs);
        HTMLTableBuilder htmlTableBuilder = new HTMLTableBuilder("all the dogs in db", true, dogs1.size(), 4, 5, 5, 5);
        htmlTableBuilder.addTableHeader("id", "age", "name", "breed");
        for (int i = dogs1.size(); i > 0; i--) {
            htmlTableBuilder.addRowValues(String.valueOf(dogs1.get(i - 1).getId()), String.valueOf(dogs1.get(i - 1).getAge()), dogs1.get(i - 1).getName(), dogs1.get(i - 1).getBreed());
        }
        String str = IOUtils.readFile("C:\\Users\\admin\\Documents\\1'web\\src\\main\\webapp\\manager.html");
        str.replace("PLACEHOLDER", htmlTableBuilder.build());
        IOUtils.write(str, "C:\\Users\\admin\\Documents\\1'web\\src\\main\\webapp\\manager.html");
        PrintWriter pw = resp.getWriter();
        String table = htmlTableBuilder.build();
        resp.setContentType("text/html");
        pw.println(table);
    }
}


