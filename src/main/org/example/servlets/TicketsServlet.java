package main.org.example.servlets;

import main.org.example.dao.*;
import main.org.example.model.Employee;
import main.org.example.model.Passport;
import main.org.example.model.Task;
import main.org.example.model.User;
import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/tickets")
public class TicketsServlet extends HttpServlet {
    private UserDAO ud = new UserDAO();
    private RoleDAO rd = new RoleDAO();
    private TaskDAO td = new TaskDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("action") != null) {
            switch (req.getParameter("action")) {
                case "A":
                    if (ServletUtils.getUserFromSession(req).getRole().getName().equals("Admin") || ServletUtils.getUserFromSession(req).getRole().getName().equals("Manager")) {
                        td.deleteById(Integer.parseInt(req.getParameter("id")));
                    } else ServletUtils.openGenericMessageJSP(req, resp, "Must be Admin or Manager");
                    break;
                case "U":
                    Task ticket = td.findById(Integer.parseInt(req.getParameter("id")));
//                    Employee employee = (Employee) edi.findById(Integer.parseInt(req.getParameter("id")));
//                    req.setAttribute("offices", odi.findAll()); // add all offices into http request
                    req.setAttribute("ticket", ticket);
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
        List<Task> tickets = td.findAll();
        List<Task> ticketsToBeRemoved = new ArrayList<>();
        if (ServletUtils.getUserFromSession(req).getRole().getName().equals("General User")) {
            tickets.forEach(ticket -> {
                if (!ticket.getUsers().contains(ServletUtils.getUserFromSession(req))) {
                    ticketsToBeRemoved.add(ticket);
                }
            });
            tickets.removeAll(ticketsToBeRemoved);
        }
        req.setAttribute("tasks", tickets);
        ServletUtils.openJSP(req, resp, "tickets");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDAO td = new TaskDAO();
        Task task = new Task();
        task.setDescr(req.getParameter("descr"));
        task.setStatus(req.getParameter("status"));
        task.setPriority(req.getParameter("priority"));
        String[] deadline = req.getParameter("deadline").split("-");
        Date date = new Date(Integer.parseInt(deadline[0]) - 1900, Integer.parseInt(deadline[1]), Integer.parseInt(deadline[2]));
        task.setDeadline(date);
        td.create(task);
        List<Task> tickets = td.findAll();
        List<Task> ticketsToBeRemoved = new ArrayList<>();
        if (ServletUtils.getUserFromSession(req).getRole().getName().equals("General User")) {
            tickets.forEach(ticket -> {
                if (!ticket.getUsers().contains(ServletUtils.getUserFromSession(req))) {
                    ticketsToBeRemoved.add(ticket);
                }
            });
            tickets.removeAll(ticketsToBeRemoved);
        }
        req.setAttribute("tasks", tickets);
        ServletUtils.openJSP(req, resp, "tickets");
    }
}
