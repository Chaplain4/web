package main.homework;

import main.homework.model.Dog;
import main.org.example.jdbc.impl.UserDAOImpl;
import main.org.example.model.User;
import main.org.example.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tester {
    public static void main(String[] args) {
        System.out.println(IOUtils.readFile("src/main/webapp/users.html"));
    }
}

