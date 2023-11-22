package main.org.example.servlets;

import main.org.example.jdbc.impl.EmployeeDAOImpl;
import main.org.example.jdbc.impl.OfficeDAOImpl;
import main.org.example.jdbc.impl.PassportDAOImpl;
import main.org.example.model.Employee;
import main.org.example.model.Office;
import main.org.example.model.Passport;
import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet("/employees")
public class EmployeesServlet extends HttpServlet {
    private EmployeeDAOImpl edi = new EmployeeDAOImpl();
    private OfficeDAOImpl odi = new OfficeDAOImpl();
    private PassportDAOImpl pdi = new PassportDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            switch (req.getParameter("action")) {
                case "D":
                    edi.deleteById(Integer.parseInt(req.getParameter("id")));
                    break;
                case "U":
                    //TODO
                case "C":
                    //create: show create form
                    req.setAttribute("offices", odi.all()); // add all offices into http request
                    ServletUtils.openJSP(req, resp, "create_empl"); // forward to jsp create form
                    return;
            }
            if (req.getParameter("action").equals("D")) {

            }
        }
        req.setAttribute("empls", edi.all());
        ServletUtils.openJSP(req, resp, "employees");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Passport passport = new Passport();
        passport.setIndID((String) req.getParameter("ind_id"));
        passport.setPersonalID((String) req.getParameter("personal_id"));

        String[] s1 = req.getParameter("exp_date").split("-");
        Date date = new Date(Integer.parseInt(s1[0]) - 1900, Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
        passport.setExpTS(date);
        Date date1 = new Date(System.currentTimeMillis());
        passport.setCreatedTS(new Timestamp(date1.getYear(), date1.getMonth(), date1.getDate(), 0,0,0,0));
        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        employee.setLastName(req.getParameter("last_name"));
        employee.setAge(Integer.parseInt(req.getParameter("age")));
        employee.setOffice(odi.findById((Integer.parseInt(req.getParameter("office")))));
        employee.setPassport(pdi.findById(pdi.createPassport2(passport)));
        if (edi.createEmployee(employee)) {
            req.setAttribute("empls", edi.all());
            ServletUtils.openJSP(req, resp, "employees");
        }

    }
}
