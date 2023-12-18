package main.org.example.jdbc.impl;

import main.org.example.jdbc.abs.RoleDAO;
import main.org.example.model.Role;
import main.org.example.util.AccountsDBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDAOImplDummy implements RoleDAO {

//    private static List<Role> roles = Arrays.asList(new Role(123, "Admin", "Admin role", null, null),
//            new Role(222, "Manager", "Manager role", null, null),
//            new Role(333, "General User", "Default role", null, null));


    @Override
    public Role findByName(String name) {
        RoleDAOImplDummy rdi = new RoleDAOImplDummy();
        Set<Role> roles = rdi.all();
        for (Role role : roles)
            if (role.getName().equalsIgnoreCase(name))
                return role;
        return null;
    }

    @Override
    public boolean create(Role type) {
        return false;
    }

    @Override
    public Role findById(Integer key) {
        RoleDAOImplDummy rdi = new RoleDAOImplDummy();
        Set<Role> roles = rdi.all();
        for (Role role : roles)
            if (role.getId().equals(key))
                return role;
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(Role type) {
        return false;
    }


    @Override
    public Set<Role> all() {
        Set<Role> roles = new HashSet<>();
        try {
        Connection connection = AccountsDBUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs1 = statement.executeQuery("SELECT * FROM roles");
        while (rs1.next()) {
            Role role = new Role();
            role.setId(rs1.getInt("id"));
            role.setName(rs1.getString("name"));
            role.setDetails(rs1.getString("details"));
            role.setCreated_ts(rs1.getTimestamp("created_ts"));
            role.setUpdated_ts(rs1.getTimestamp("updated_ts"));
            roles.add(role);
        }
        return roles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Role map(Role role, ResultSet rs) {
        return null;
    }
}
