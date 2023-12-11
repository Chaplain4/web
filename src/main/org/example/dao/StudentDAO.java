package main.org.example.dao;

import main.org.example.model.Student;
import main.org.example.util.HibernateUtil;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public Student getStudentById(int id) {
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            student = session.get(Student.class, id);
        }
        return student;
    }

    public void update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student1 = getStudentById(student.getId());
            student1 = student;
            session.saveOrUpdate(student1);
        }
    }

    public void delete(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                session.delete(student);
            }
        }
    }


    public List<Student> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select s from Student s");
            return query.getResultList();
        }
    }

    public List<Student> getAllByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select s from Student s where s.firstName like  :name");
            query.setParameter("name", name);
            return query.getResultList();
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student student = new Student();
        student.setFirstName("John3");
        student.setLastName("Johnson2");
        student.setEmail("Johnson3@gmail.com");
        dao.saveStudent(student);
        System.out.println(dao.getAll().size());
        System.out.println(dao.getAllByName("J%"));
        Student student1 = dao.getStudentById(1);
        System.out.println(student1);
        student1.setGender("M");
        dao.update(student1);
        System.out.println(student1);
//        Student st1 = dao.getStudentById(3);
//        System.out.println(st1);
//        st1.setGender("Male");
//        dao.update(st1);
    }
}