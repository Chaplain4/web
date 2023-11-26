package main.org.example.jdbc.impl;

import main.org.example.jdbc.abs.RoleDAO;
import main.org.example.model.Role;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

public class RoleDAOImpl implements RoleDAO {

    @Override
    public Role findByName(String name) {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM roles WHERE name = ?"); {
                pstmt.setString(1,name);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Role role = new Role();
                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("name"));
                    role.setDetails(rs.getString("details"));
                    role.setCreated_ts(rs.getTimestamp("created_ts"));
                    role.setUpdated_ts(rs.getTimestamp("updated_ts"));
                    return role;
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean create(Role type) {
        return false;
    }

    @Override
    public Role findById(Integer key) {
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
        return null;
    }
}
