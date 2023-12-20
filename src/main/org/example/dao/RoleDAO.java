package main.org.example.dao;

import main.org.example.model.Passport;
import main.org.example.model.Role;
import main.org.example.util.DBUtils;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDAO extends AbstractJpaDAO<Integer, Role> {

    public Role findByName(String name) {
        RoleDAO dao = new RoleDAO();
        return dao.findByCondition("WHERE name = '" + name + "'");
    }
}
