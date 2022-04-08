package pro.sky.Errors;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
    void init();
    Employee getEmployee(int number) ;
    int search(String name, String lastname);
    Employee add(String name, String lastName);
    Employee remove(String name, String lastName);
    Employee find(String name, String lastName);
    HashMap<String,Employee> maplistEmployee();
}