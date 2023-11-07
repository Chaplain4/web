package main.homework;

import main.homework.model.Dog;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DogDAOImpl implements DogDAO {
    public Dog findById(int id) {
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
                return dog;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Set<Dog> all() {
        try {
            Set<Dog> dogs = new HashSet<>();
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM dogs");
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setId(rs.getInt("id"));
                dog.setAge(rs.getInt("age"));
                dog.setName(rs.getString("name"));
                dog.setBreed(rs.getString("breed"));
                dogs.add(dog);
            }
            return dogs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

