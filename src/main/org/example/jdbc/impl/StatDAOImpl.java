package main.org.example.jdbc.impl;

import main.org.example.jdbc.abs.StatDAO;
import main.org.example.model.Stat;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class StatDAOImpl implements StatDAO {

    @Override
    public boolean create(Stat stat) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement
                     ("INSERT INTO stats (name, email, age, education, would_recommend, languages_known, comments) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, stat.getName());
            pstmt.setString(2, stat.getEmail());
            pstmt.setInt(3, stat.getAge());
            pstmt.setString(4, stat.getEducation());
            pstmt.setString(5, stat.getWouldRecommend());
            pstmt.setString(6, stat.getLanguagesKnown());
            pstmt.setString(7, stat.getComments());

            if (pstmt.executeUpdate() > 0) {
                System.out.println("User successfully created ");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Stat findById(Integer key) {
        return null;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public boolean update(Stat type) {
        return false;
    }

    @Override
    public Set<Stat> all() {
        return null;
    }
}
