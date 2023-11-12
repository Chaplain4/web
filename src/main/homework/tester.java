package main.homework;

import main.homework.model.Dog;
import main.org.example.util.AccountsDBUtils;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tester {
    public static void main(String[] args) {
        try {
            Connection connection = AccountsDBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                System.out.println(rs.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

