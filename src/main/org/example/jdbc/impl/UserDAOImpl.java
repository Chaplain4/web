package main.org.example.jdbc.impl;

import main.org.example.jdbc.abs.UserDAO;
import main.org.example.model.Role;
import main.org.example.model.User;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    @Override
    public Set<User> findByRole(Role role) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void activate(User user) {

    }

    @Override
    public boolean create(User user) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement
                     ("INSERT INTO users (name, email, pwd, details, role, is_active, created_ts) VALUES (?, ?, ?, ?, 'General User', '0', CURRENT_TIMESTAMP)")) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPwd());
            pstmt.setString(4, user.getDetails());
            if (pstmt.executeUpdate() > 0 ) {
                System.out.println("User successfully created");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(Integer key) {
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(User type) {
        return false;
    }

    @Override
    public Set<User> all() {
        return null;
    }
}
