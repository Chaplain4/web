package main.org.example.dao;


import main.org.example.model.Employee;
import main.org.example.model.Office;
import main.org.example.model.Role;
import main.org.example.model.Task;
import main.org.example.service.JPAService;
import org.hibernate.Session;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
//
        TaskDAO dao1 = new TaskDAO();
//        Task task = new Task();
//        task.setDescr("Fix bug");
//        task.setStatus("In progress");
//        task.setPriority("Critical");
//        task.setDeadline(new Date(new java.util.Date().getTime()));
//        dao.create(task);
        RoleDAO dao = new RoleDAO();
        UserDAO dao2 = new UserDAO();
        System.out.println(dao2.findAll());
    }
}
