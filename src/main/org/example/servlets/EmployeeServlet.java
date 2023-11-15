package main.org.example.servlets;

import main.homework.DogDAOImpl;
import main.homework.model.Dog;
import main.org.example.jdbc.impl.EmployeeDAOImpl;
import main.org.example.model.Employee;
import main.org.example.util.HTMLTableBuilder;
import main.org.example.util.IOUtils;

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

import static main.org.example.util.ServletUtils.info;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        info(req, "employee -> doGet()");
        RequestDispatcher rd = req.getRequestDispatcher("/employee.html");
        rd.forward(req, resp); //move forward with the same params and so on
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        EmployeeDAOImpl edi = new EmployeeDAOImpl();
        info(req, "employee -> doPost()");
        if (req.getParameter("id") == null || req.getParameter("id").equals("")) {
            Set<Employee> employees = edi.all();
            List<Employee> employees1 = new ArrayList<>(employees);
            HTMLTableBuilder htmlTableBuilder = new HTMLTableBuilder("all the employees in db", true, employees1.size(), 8, 5, 5, 5);
            htmlTableBuilder.addTableHeader("id", "name", "lastname", "age", "office", "passport", "updatedTS", "createdTS");
            for (int i = employees1.size(); i > 0; i--) {
                htmlTableBuilder.addRowValues(String.valueOf(employees1.get(i - 1).getId()), String.valueOf(employees1.get(i - 1).getName()), employees1.get(i - 1).getLastName(),
                        String.valueOf(employees1.get(i - 1).getAge()), String.valueOf(employees1.get(i - 1).getOffice().getTitle()), String.valueOf(employees1.get(i - 1).getPassport().getPersonalID()),
                        String.valueOf(employees1.get(i - 1).getCreatedTs()), String.valueOf(employees1.get(i - 1).getUpdatedTs()));
            }
            //String template = IOUtils.readFile("pathname");
            //template.replace("USERS", htmlTableBuilder.build());
            String table = htmlTableBuilder.build();
            resp.setContentType("text/html");
            pw.println(table);
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            if (edi.findById(id) != null){
                pw.println(edi.findById(id).toString());
            } else
                pw.println("No employee found");
        }
    }
}

