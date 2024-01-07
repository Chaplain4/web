package main.org.example.servlets;

import main.org.example.dao.RoleDAO;
import main.org.example.dao.TaskDAO;
import main.org.example.dao.UserDAO;
import main.org.example.model.Employee;
import main.org.example.model.Task;
import main.org.example.model.User;
import main.org.example.util.EmailUtils;
import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/update_ticket")
public class TicketUpdateServlet extends HttpServlet {
    private UserDAO ud = new UserDAO();
    private RoleDAO rd = new RoleDAO();
    private TaskDAO td = new TaskDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = td.findById(Integer.parseInt(req.getParameter("id")));
        task.setDescr(req.getParameter("descr"));
        task.setStatus(req.getParameter("status"));
        task.setPriority(req.getParameter("priority"));
        String[] deadline = req.getParameter("deadline").split("-");
        Date date = new Date(Integer.parseInt(deadline[0]) - 1900, Integer.parseInt(deadline[1]), Integer.parseInt(deadline[2]));
        task.setDeadline(date);
        td.saveOrUpdate(task);
        List <Task> tickets = td.findAll();
        List <Task> ticketsToBeRemoved = new ArrayList<>();
        if (ServletUtils.getUserFromSession(req).getRole().getName().equals("General User")) {
            tickets.forEach(ticket -> {
                if (!ticket.getUsers().contains(ServletUtils.getUserFromSession(req))) {
                    ticketsToBeRemoved.add(ticket);
                }
            });
            tickets.removeAll(ticketsToBeRemoved);
        }
        req.setAttribute("tasks", tickets);
        if (task.getStatus().equals("Completed")) {
            List<User> users = ud.findAll();
            Set<String> managers = new HashSet<>();
            Set<String> managers1 = new HashSet<>();
            users.forEach(user -> {
                if (user.getRole().getName().equals("Manager")) {
                    managers.add(user.getEmail());
                }
            });
            //EmailUtils.send(managers,null,null, "task complete",task.getDescr() + " completed", null);
            System.out.println("msg sent to " + managers + " task " + task.getDescr() + " complete");
        }
        ServletUtils.openJSP(req, resp, "tickets");
    }
}