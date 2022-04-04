package pro.sky.Errors;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(int number) ;
    int search(String name, String lastname);
    Employee add(String name, String lastName);
    Employee remove(String name, String lastName);
    Employee find(String name, String lastName);
    List<Employee> listEmployee();
}