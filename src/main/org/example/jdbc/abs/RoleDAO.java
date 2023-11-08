package main.org.example.jdbc.abs;

import main.org.example.model.Role;

public interface RoleDAO extends AbstractDAO<Role, Integer> {
    Role findByName(String name);
}