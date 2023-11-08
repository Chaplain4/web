package main.org.example.jdbc.abs;

import main.org.example.model.Role;
import main.org.example.model.User;

import java.util.Set;

public interface UserDAO extends AbstractDAO<User, Integer> {
    Set<User> findByRole(Role role);
    User findByEmail(String email);
    void activate(User user);
    //..
}
