package main.org.example.dao;

import main.org.example.model.Passport;
import main.org.example.service.JPAService;

public class PassportDAO extends AbstractJpaDAO<Integer, Passport> {

    public int createPassport2(Passport passport) {
        try {
            passport.setId(null);
            create(passport);
            return 1;
        } catch (Throwable t) {
            t.printStackTrace();
            return -1;
        }

    }
}
