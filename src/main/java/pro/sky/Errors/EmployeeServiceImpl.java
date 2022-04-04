package pro.sky.Errors;

import org.springframework.stereotype.Service;
import pro.sky.Errors.Exception.AddExceptionBadReques;
import pro.sky.Errors.Exception.AddExceptionInternalServerError;
import pro.sky.Errors.Exception.FindException;
import pro.sky.Errors.Exception.RemoveException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employee = new ArrayList<>(Arrays.asList(
            new Employee("Lex", "Lutor"),
            new Employee("Lois", "Laine"),
            new Employee(null, null),
            new Employee("Clark", "Kent"),
            new Employee("Oliver", "Queen"),
            new Employee("Viktor", "Stone"),
            new Employee(null, null)
            ));

    public Employee getEmployee(int number) {
        if (number >= employee.size()) {
            throw new FindException();
        }
        return employee.get(number);
    }


    public int search(String name, String lastname) {
        for (int i = 0; i < employee.size(); i++) {
            if ((employee.get(i) != null) && (employee.get(i).getName() != null)) {//if1
                Employee employe = new Employee(name,lastname);
                if(employe.equals(employee.get(i))) return i;
            }//if1
        }//for
        return employee.size();
    }

    public Employee add(String name, String lastName) {
        int person = search(name, lastName);
        if (person < employee.size()) throw new AddExceptionBadReques();

                Employee employe = new Employee(name, lastName);
                employee.add(employe);
                return employe;

    }

    public Employee remove(String name, String lastName) {
        int person = search(name, lastName);
        if (person < employee.size()) {
            Employee tmp = employee.get(person);
            employee.remove(person);
            return tmp;
        }
        throw new RemoveException();

    }


    public Employee find(String name, String lastName) {
        int person = search(name, lastName);
        if (person < employee.size()) {
            return employee.get(person);
        }
        throw new FindException();

    }

    @Override
    public List<Employee> listEmployee() {
        return employee;
    }
}