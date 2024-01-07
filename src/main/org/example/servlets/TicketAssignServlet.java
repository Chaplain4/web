package main.org.example.servlets;

import main.org.example.dao.RoleDAO;
import main.org.example.dao.TaskDAO;
import main.org.example.dao.UserDAO;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/assign_ticket")
public class TicketAssignServlet extends HttpServlet {
    private UserDAO ud = new UserDAO();
    private RoleDAO rd = new RoleDAO();
    private TaskDAO td = new TaskDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = td.findById(Integer.parseInt(req.getParameter("id")));
        User user = ud.findById(Integer.parseInt(req.getParameter("user_id")));
        task.getUsers().add(user);
        td.saveOrUpdate(task);

        List<Task> tickets = td.findAll();
        List <Task> ticketsToBeRemoved = new ArrayList<>();
        if (ServletUtils.getUserFromSession(req).getRole().getName().equals("General User")) {
            tickets.forEach(ticket -> {
                if (!ticket.getUsers().contains(ServletUtils.getUserFromSession(req))) {
                    ticketsToBeRemoved.add(ticket);
                }
            });
            tickets.removeAll(ticketsToBeRemoved);
        }
        EmailUtils.send(user.getEmail(), "task assigned", task.getDescr() + " assigned");
        System.out.println("msg sent to " + user.getEmail() + " " + task.getDescr() + " assigned");
        req.setAttribute("tasks", tickets);
        ServletUtils.openJSP(req, resp, "tickets");
    }
}
