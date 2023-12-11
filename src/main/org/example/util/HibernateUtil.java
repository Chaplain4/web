package main.org.example.util;

import main.org.example.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.selector.SimpleStrategyRegistrationImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties props = new Properties();
            props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            props.put(Environment.URL, "jdbc:mysql://127.0.0.1:3307/users_db");
            props.put(Environment.USER, "root");
            props.put(Environment.PASS, "");
            props.put(Environment.SHOW_SQL, "true");
            props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            props.put(Environment.HBM2DDL_AUTO, "create-drop");
            configuration.setProperties(props);
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } else return sessionFactory;
    }
}
