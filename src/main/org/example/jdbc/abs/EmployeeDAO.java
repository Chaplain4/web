package main.org.example.jdbc.abs;


import main.org.example.model.Employee;
import main.org.example.model.Office;

import java.util.Set;

public interface EmployeeDAO {
    boolean createEmployee(Employee employee);
    Employee findById(int id);
    boolean deleteById(int id);
    boolean updateEmployee(Employee employee);
    Set<Employee> all();
    Set<Employee> getAllByOfficeID(Office office);
}

