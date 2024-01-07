package main.org.example.dao;


import main.org.example.model.*;
import main.org.example.service.JPAService;
import org.hibernate.Session;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        TaskDAO dao1 = new TaskDAO();
        Task task = dao1.findById(7);
        task.getUsers().add(dao.findById(3));
        dao1.saveOrUpdate(task);
//        employee.getTasks().add(dao1.findById(1));
        //System.out.println(dao2.findAll());
    }
}
