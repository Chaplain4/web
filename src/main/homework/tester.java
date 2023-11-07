package main.homework;

import main.homework.model.Dog;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tester {
    public static void main(String[] args) {
        int id = 2;
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM dogs where id = " + id);
            if (rs.next()) {
                Dog dog = new Dog();
                dog.setId(rs.getInt("id"));
                dog.setAge(rs.getInt("age"));
                dog.setName(rs.getString("name"));
                dog.setBreed(rs.getString("breed"));
                System.out.println(dog.toString());
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        DogDAOImpl dda = new DogDAOImpl();
        System.out.println(dda.findById(2).toString());
    }
}

