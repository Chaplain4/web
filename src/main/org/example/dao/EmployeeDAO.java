package main.org.example.dao;

import main.org.example.model.Employee;
import main.org.example.service.JPAService;

public class EmployeeDAO extends AbstractJpaDAO<Integer, Employee> {


    public boolean create2(Employee employee) {
        try {
            employee.setId(null);
            create(employee);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public boolean saveOrUpdate2(Employee employee) {
        try {
            saveOrUpdate(employee);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }
}
