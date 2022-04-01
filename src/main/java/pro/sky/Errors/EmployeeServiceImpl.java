package pro.sky.Errors;

import org.springframework.stereotype.Service;
import pro.sky.Errors.Exception.AddExceptionBadReques;
import pro.sky.Errors.Exception.AddExceptionInternalServerError;
import pro.sky.Errors.Exception.FindException;
import pro.sky.Errors.Exception.RemoveException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employee[] employee = {
            new Employee("Lex", "Lutor"),
            new Employee("Lois", "Laine"),
            new Employee(null, null),
            new Employee("Clark", "Kent"),
            new Employee("Oliver", "Queen"),
            new Employee("Viktor", "Stone"),
            new Employee(null, null),

    };

    public Employee getEmployee(int number) {
        if (number >= employee.length) {
            throw new FindException();
        }
        Employee employees = employee[number];
        final String EmployeeDescription = ""
                + employees.getName() + " "
                + employees.getLastName();
        //return EmployeeDescription;
        return employee[number];
    }


    public int search(String name, String lastname) {
        for (int i = 0; i < employee.length; i++) {
            if ((employee[i] != null) && (employee[i].getName() != null)) {//if1
                if ((employee[i].getName().equals(name)) && (employee[i].getLastName().equals(lastname))) {
                    return i;
                }
            }//if1
        }//for
        return employee.length;
    }

    public Employee add(String name, String lastName) {
        int person = search(name, lastName);
        if (person < employee.length) throw new AddExceptionBadReques();
        for (int i = 0; i < employee.length; i++) {
            if ((employee[i] == null) || (employee[i].getName() == null)) {
                employee[i] = new Employee(name, lastName);
                return employee[i];
            }
        }
        throw new AddExceptionInternalServerError();
    }

    public Employee remove(String name, String lastName) {
        int person = search(name, lastName);
        if (person < employee.length) {
            Employee tmp = employee[person];
            employee[person] = null;
            return tmp;
        }
        throw new RemoveException();

    }


    public Employee find(String name, String lastName) {
        int person = search(name, lastName);
        if (person < employee.length) {
            return employee[person];
        }
        throw new FindException();

    }
}