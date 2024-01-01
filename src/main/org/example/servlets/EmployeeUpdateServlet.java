package main.org.example.servlets;

import main.org.example.dao.EmployeeDAO;
import main.org.example.dao.OfficeDAO;
import main.org.example.dao.PassportDAO;
import main.org.example.jdbc.impl.EmployeeDAOImpl;
import main.org.example.jdbc.impl.OfficeDAOImpl;
import main.org.example.jdbc.impl.PassportDAOImpl;
import main.org.example.model.Employee;
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

@WebServlet("/update")
public class EmployeeUpdateServlet extends HttpServlet {
    private EmployeeDAO edi = new EmployeeDAO();
    private OfficeDAO odi = new OfficeDAO();
    private PassportDAO pdi = new PassportDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = edi.findById(Integer.parseInt(req.getParameter("id")));
        Passport passport = employee.getPassport();
        passport.setIndID(req.getParameter("ind_id"));
        passport.setPersonalID(req.getParameter("personal_id"));
        String[] s1 = req.getParameter("exp_date").split("-");
        Date date = new Date(Integer.parseInt(s1[0]) - 1900, Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
        passport.setExpTS(date);
        Date date1 = new Date(System.currentTimeMillis());
        passport.setCreatedTS(new Timestamp(date1.getYear(), date1.getMonth(), date1.getDate(), 0, 0, 0, 0));
        employee.setName(req.getParameter("name"));
        employee.setLastName(req.getParameter("last_name"));
        employee.setAge(Integer.parseInt(req.getParameter("age")));
        employee.setOffice(odi.findById((Integer.parseInt(req.getParameter("office")))));
        if (!passport.equals(edi.findById(Integer.parseInt(req.getParameter("id"))).getPassport())) {
            pdi.create(passport);
            passport.setId(null);
            employee.setPassport(passport);
        }
        edi.saveOrUpdate(employee);
        req.setAttribute("empls", edi.findAll());
        ServletUtils.openJSP(req, resp, "employees");
    }
}
