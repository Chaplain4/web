package main.org.example.jdbc.impl;

import main.org.example.jdbc.abs.UserDAO;
import main.org.example.model.Role;
import main.org.example.model.User;
import main.org.example.util.AccountsDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImplDummy implements UserDAO {
    private static List<User> users;
    private RoleDAOImplDummy roleDAO = new RoleDAOImplDummy();

    static {

        RoleDAOImplDummy roleDAO = new RoleDAOImplDummy();
        users = new ArrayList<>();
        users.add(new User(1233, "John", "John@gmail.com",
                "123", "Some details", roleDAO.findByName("Admin"), true, null, null));
        users.add(new User(2135235, "Bob", "Bob@gmail.com",
                "123", "Some details", roleDAO.findByName("Manager"), true, null, null));
        users.add(new User(2356346, "Mike", "Mike@gmail.com",
                "123", "Some details", roleDAO.findByName("General_User"), true, null, null));

    }

    @Override
    public Set<User> findByRole(Role role) {
        Set<User> roleUsers = new HashSet<>();
        for (User user : users)
            if (user.getRole().equals(role))
                roleUsers.add(user);
        return roleUsers;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users)
            if (user.getEmail().equalsIgnoreCase(email))
                return user;
        return null;
    }

    @Override
    public void activate(User user) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                if (user.getIsActive().equals(true)) {
                    user.setIsActive(false);
                } else user.setIsActive(true);
                System.out.println("user with email " + user.getEmail() + " is Activated now");
            }
        }
    }

    @Override
    public boolean create(User type) {
        type.setCreated_ts(new Timestamp(System.currentTimeMillis()));
        type.setIsActive(false);
        type.setRole(roleDAO.findByName("General User"));
        System.out.println("user with email " + type.getEmail() + " is added");
        return users.add(type);
    }

    @Override
    public User findById(Integer key) {
        for (User user : users)
            if (user.getId().equals(key))
                return user;
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        for (User user : users)
            if (user.getId().equals(key)) {
                users.remove(user);
                return true;
            }
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public Set<User> all() {
        try {
            Set<User> users = new HashSet<>();
            RoleDAOImplDummy rdi = new RoleDAOImplDummy();
            Set<Role> roles = rdi.all();
            Connection connection = AccountsDBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("pwd"));
                user.setDetails(rs.getString("details"));
                for (Role role : roles) {
                    if (role.getName().equals(rs.getString("role"))) {
                        user.setRole(role);
                    }
                }
                user.setIsActive(rs.getBoolean("is_active"));
                user.setCreated_ts(rs.getTimestamp("created ts"));
                user.setUpdated_ts(rs.getTimestamp("updated ts"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
