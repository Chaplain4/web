package main.org.example.util;

import lombok.SneakyThrows;

import java.sql.*;

public class AccountsDBUtils {
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/accounts_db";

    private AccountsDBUtils() {

    }

    @SneakyThrows
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void release(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                System.out.println("Connection " + conn + " is closed");
                conn.close();
            }
            if (stmt != null) {
                System.out.println("Statement " + stmt + " is closed");
                stmt.close();
            }
            if (rs != null) {
                System.out.println("Result set " + rs + " is closed");
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
