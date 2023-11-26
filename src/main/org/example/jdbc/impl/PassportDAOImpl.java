package main.org.example.jdbc.impl;


import main.org.example.jdbc.abs.PassportDAO;
import main.org.example.model.Passport;
import main.org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class PassportDAOImpl implements PassportDAO {
    @Override
    public boolean createPassport(Passport passport) {
        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `passport` (`id`, `personal_id`, `ind_id`, `exp_ts`, `created_ts`) VALUES " +
                    "(NULL, '" + passport.getPersonalID() + "', '" + passport.getIndID() + "' , '" + passport.getExpTS() +
                    "', CURRENT_DATE)";
            int count = statement.executeUpdate(sql);
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int createPassport2(Passport passport) {
        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `passport` (`id`, `personal_id`, `ind_id`, `exp_ts`, `created_ts`) VALUES " +
                    "(NULL, '" + passport.getPersonalID() + "', '" + passport.getIndID() + "' , '" + passport.getExpTS() +
                    "', CURRENT_DATE)";
            int count = statement.executeUpdate(sql);
            if (count == 1) {
                ResultSet rs = statement.executeQuery("SELECT * FROM `passport` WHERE id = (SELECT MAX(id) FROM `passport`)");
                if (rs.next()) {
                    return rs.getInt("id");
                } else return -1;
            } else return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Passport findById(int id) {
        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM passport where id =" + id);
            if (rs.next()) {
                Passport passport = new Passport();
                passport.setId(id);
                passport.setPersonalID(rs.getString("personal_id"));
                passport.setIndID(rs.getString("ind_id"));
                passport.setExpTS(rs.getDate("exp_ts"));
                passport.setCreatedTS(rs.getTimestamp("created_ts"));
                return passport;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        try(Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM passport where id =" + id);
            if (findById(id) == null) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassport(Passport passport) {
        try (Connection connection = DBUtils.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute("UPDATE passport SET personal_id = '" + passport.getPersonalID() + "', ind_id = '" + passport.getIndID() + "', exp_ts = " +
                    "'" + passport.getExpTS() + "', created_ts = '" + passport.getCreatedTS() + "'  WHERE id = " + passport.getId());
            if (findById(passport.getId()).equals(passport)) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Passport> all() {
        Set<Passport> passports = new HashSet<>();
        try (Connection connection = DBUtils.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM passport");
            while (rs.next()) {
                Passport passport = new Passport();
                passport.setId(rs.getInt("id"));
                passport.setPersonalID(rs.getString("personal_id"));
                passport.setIndID(rs.getString("ind_id"));
                passport.setExpTS(rs.getDate("exp_ts"));
                passport.setCreatedTS(rs.getTimestamp("created_ts"));
                passports.add(passport);
            }
            return passports;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
