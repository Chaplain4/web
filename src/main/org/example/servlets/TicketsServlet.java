package main.org.example.servlets;

import main.org.example.dao.*;
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

@WebServlet("/tickets")
public class TicketsServlet extends HttpServlet {
    private UserDAO ud = new UserDAO();
    private RoleDAO rd = new RoleDAO();
    private TaskDAO td = new TaskDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            switch (req.getParameter("action")) {
                case "D":
                    if (ServletUtils.getUserFromSession(req).getRole().getName().equals("Admin") || ServletUtils.getUserFromSession(req).getRole().getName().equals("Manager")) {
                        td.deleteById(Integer.parseInt(req.getParameter("id")));
                    } else ServletUtils.openGenericMessageJSP(req, resp, "Must be Admin or Manager");
                    break;
                case "U":
//                    Employee employee = (Employee) edi.findById(Integer.parseInt(req.getParameter("id")));
//                    req.setAttribute("offices", odi.findAll()); // add all offices into http request
//                    req.setAttribute("empl", employee);
                    ServletUtils.openJSP(req, resp, "update_ticket");
                    return;
                case "C":
                    //create: show create form
                    if (ServletUtils.getUserFromSession(req).getRole().getName().equals("Manager") || ServletUtils.getUserFromSession(req).getRole().getName().equals("Admin")) {
                        req.setAttribute("users", ud.findAll()); // add all users into http request
                        ServletUtils.openJSP(req, resp, "create_ticket"); // forward to jsp create form
                    } else ServletUtils.openGenericMessageJSP(req, resp, "Must be Admin or Manager");
                    return;
            }
        }
        req.setAttribute("tasks", td.findAll());
        ServletUtils.openJSP(req, resp, "tickets");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Passport passport = new Passport();
//        passport.setIndID(req.getParameter("ind_id"));
//        passport.setPersonalID(req.getParameter("personal_id"));
//        String[] s1 = req.getParameter("exp_date").split("-");
//        Date date = new Date(Integer.parseInt(s1[0]) - 1900, Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
//        passport.setExpTS(date);
//        Date date1 = new Date(System.currentTimeMillis());
//        passport.setCreatedTS(new Timestamp(date1.getYear(), date1.getMonth(), date1.getDate(), 0, 0, 0, 0));
//        Employee employee = new Employee();
//        employee.setName(req.getParameter("name"));
//        employee.setLastName(req.getParameter("last_name"));
//        employee.setAge(Integer.parseInt(req.getParameter("age")));
//        employee.setOffice(odi.findById((Integer.parseInt(req.getParameter("office")))));
//        employee.setPassport(passport);
//        pdi.create(employee.getPassport());
//        employee.getPassport().setId(null);
//        employee.setCreatedTs(new Timestamp(date1.getYear(), date1.getMonth(), date1.getDate(), 0, 0, 0, 0));
//        edi.create(employee);
        req.setAttribute("tasks", td.findAll());
        ServletUtils.openJSP(req, resp, "tickets");
    }
}
