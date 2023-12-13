package main.org.example.dao;

import main.org.example.model.Passport;
import main.org.example.model.Student;
import main.org.example.util.HibernateUtil;
import java.util.List;

public class StudentDAO {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void saveStudent(Student student) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getEntityManagerFactory().openSession()) {
//            // start transaction
//            transaction = session.beginTransaction();
//            session.save(student);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if(transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//        }
        hibernateUtil.saveOrUpdate(student);
    }

    public Student getStudentById(int id) {
//        Student student = null;
//        try (Session session = HibernateUtil.getEntityManagerFactory().openSession()) {
//            student = session.get(Student.class, id);
//        }
//        return student;
        return hibernateUtil.findById(Student.class, id);
    }

    public void update(Student student) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getEntityManagerFactory().openSession()) {
//            Student student1 = getStudentById(student.getId());
//            student1 = student;
//            session.saveOrUpdate(student1);
//        } catch (Exception e) {
//            e.printStackTrace();
//            if(transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//        }
        hibernateUtil.update(student);
    }

    public void delete(int id) {
//        Student student = getStudentById(id);
//        if (student != null) {
//            try (Session session = HibernateUtil.getEntityManagerFactory().openSession()) {
//                session.delete(student);
//            }
//        }
        hibernateUtil.deleteById(Student.class, id);
    }


    public List<Student> getAll() {
//        try (Session session = HibernateUtil.getEntityManagerFactory().openSession()) {
//            Query query = session.createQuery("select s from Student s");
//            return query.getResultList();
//        }
        return hibernateUtil.findAll(Student.class);
    }

    public List<Student> getAllByName(String name) {
//        try (Session session = HibernateUtil.getEntityManagerFactory().openSession()) {
//            Query query = session.createQuery("select s from Student s where s.firstName like  :name");
//            query.setParameter("name", name);
//            return query.getResultList();
//        }
        return hibernateUtil.findAll(Student.class, "where o.firstName like '" + name + "'");
    }

    public static void main(String[] args) {
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
        HibernateUtil hibernateUtil = new HibernateUtil();
        System.out.println(hibernateUtil.findAll(Passport.class));
        System.out.println(hibernateUtil.findById(Passport.class, 13));

//        Student st1 = dao.getStudentById(3);
//        System.out.println(st1);
//        st1.setGender("Male");
//        dao.update(st1);
    }
}