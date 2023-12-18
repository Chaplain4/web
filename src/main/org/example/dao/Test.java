package main.org.example.dao;


import main.org.example.model.Employee;
import main.org.example.model.Office;
import main.org.example.service.JPAService;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        System.out.println(dao.findAll());


    }
}
