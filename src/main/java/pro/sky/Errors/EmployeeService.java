package pro.sky.Errors;

import java.util.HashMap;

public interface EmployeeService {
    Employee find(String name, String lastName);

    Employee remove(String name, String lastName);

    Employee add(String name, String lastName);

    void initMap();

    HashMap<String,Employee> mapListEmployee();
}