package main.org.example.dao;

import main.org.example.model.Role;
import main.org.example.model.User;
import main.org.example.util.DBUtils;

public class UserDAO extends AbstractJpaDAO<Integer, User> {
    public User findByEmail(String email) {
        UserDAO dao = new UserDAO();
        return dao.findByCondition("WHERE email = '" + email + "'");
    }

    public void activate(User user) {
        UserDAO dao = new UserDAO();
        user.setIsActive(true);
        dao.saveOrUpdate(user);
    }
}
