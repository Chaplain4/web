package main.homework;

import main.homework.model.Dog;
import main.org.example.jdbc.impl.UserDAOImpl;
import main.org.example.model.User;
import main.org.example.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class tester {
    public static void main(String[] args) {
        DogDAOImpl ddi = new DogDAOImpl();
        Set<Dog> dogs = ddi.all();
        List<Dog> dogs1 = new ArrayList<>(dogs);
        HTMLTableBuilder htmlTableBuilder = new HTMLTableBuilder("all the dogs in db", true, dogs1.size(), 4, 5, 5, 5);
        htmlTableBuilder.addTableHeader("id", "age", "name", "breed");
        for (int i = dogs1.size(); i > 0; i--) {
            htmlTableBuilder.addRowValues(String.valueOf(dogs1.get(i - 1).getId()), String.valueOf(dogs1.get(i - 1).getAge()), dogs1.get(i - 1).getName(), dogs1.get(i - 1).getBreed());
        }
        String str = IOUtils.readFile("C:\\Users\\admin\\Documents\\1'web\\src\\main\\webapp\\manager.html");
        String str2 = htmlTableBuilder.build();
        System.out.println(str.replace("123456", str2));
        //IOUtils.write(str, "C:\\Users\\admin\\Documents\\1'web\\src\\main\\webapp\\manager.html");
    }
}

