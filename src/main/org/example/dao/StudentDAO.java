package main.org.example.dao;

import main.org.example.model.Passport;
import main.org.example.model.Student;
import main.org.example.service.JPAService;
import java.util.List;

public class StudentDAO extends AbstractJpaDAO<Integer, Student> {


    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        student.setFirstName("John31");
        student.setLastName("Johnson223");
        student.setEmail("Johnso1n3@gmail.com");
        dao.create(student);
//        StudentDAO dao = new StudentDAO();
//        Student student = new Student();
//        student.setFirstName("John3");
//        student.setLastName("Johnson2");
//        student.setEmail("Johnson3@gmail.com");
//        dao.saveStudent(student);
//        System.out.println(dao.getAll().size());
//        System.out.println(dao.getAllByName("J%"));
//        Student student1 = dao.getStudentById(1);
//        System.out.println(student1);
//        student1.setGender("M");
//        dao.update(student1);
//        System.out.println(student1);
        JPAService JPAService = new JPAService();
        System.out.println(JPAService.findAll(Passport.class));
        System.out.println(JPAService.findById(Passport.class, 13));

//        Student st1 = dao.getStudentById(3);
//        System.out.println(st1);
//        st1.setGender("Male");
//        dao.update(st1);
    }
}