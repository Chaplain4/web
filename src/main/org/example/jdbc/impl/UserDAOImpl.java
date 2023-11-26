package main.org.example.jdbc.impl;

import main.org.example.jdbc.abs.UserDAO;
import main.org.example.model.Office;
import main.org.example.model.Role;
import main.org.example.model.User;
import main.org.example.util.DBUtils;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    private RoleDAOImpl roleDAO = new RoleDAOImpl();

    @Override
    public User findByEmail(String email) {
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setDetails(rs.getString("details"));
                user.setRole(roleDAO.findByName(rs.getString("role")));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setCreated_ts(rs.getTimestamp("created_ts"));
                user.setUpdated_ts(rs.getTimestamp("updated_ts"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<User> findByRole(Role role) {
        return null;
    }

    @Override
    public void activate(User user) {

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement
                     ("UPDATE users SET is_active = '1', UPDATED_TS = CURRENT_TIMESTAMP WHERE users.email = ?")) {
            pstmt.setString(1, user.getEmail());
            if (pstmt.executeUpdate() > 0) {
                System.out.println("User successfully activated!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

            if (pstmt.executeUpdate() > 0) {
                System.out.println("User successfully created ");
                return true;
            }
            ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(Integer key) {
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, key);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setDetails(rs.getString("details"));
                user.setRole(roleDAO.findByName(rs.getString("role")));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setCreated_ts(rs.getTimestamp("created_ts"));
                user.setUpdated_ts(rs.getTimestamp("updated_ts"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(User user) {
        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("UPDATE users SET name = '" + user.getName() + "', email = '" + user.getEmail() +
                    "', pwd = '" + user.getPwd() + "', details = '" + user.getDetails() + "', role = '" + user.getRole().getName() +
                    "', is_active = '" + (user.getIsActive() ? 1 : 0) + "', created_ts = '" + user.getCreated_ts() + "', updated_ts = CURRENT_TIMESTAMP WHERE id = " + user.getId());
            if (findById(user.getId()).equals(user)) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Set<User> all() {
        Set<User> users = new HashSet<>();
        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setDetails(rs.getString("details"));
                user.setRole(roleDAO.findByName(rs.getString("role")));
                user.setIsActive(rs.getBoolean("is_active"));
                user.setCreated_ts(rs.getTimestamp("created_ts"));
                user.setUpdated_ts(rs.getTimestamp("updated_ts"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
