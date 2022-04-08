package pro.sky.Errors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pro.sky.Errors.Exception.AddExceptionBadReques;
import pro.sky.Errors.Exception.FindException;
import pro.sky.Errors.Exception.RemoveException;

import java.util.*;

 class Abc implements InitializingBean {
    public void afterPropertiesSet() {
        System.out.println("Look, mum, i'm running in late initialization stage!");
    }
}
@Service
public class EmployeeServiceImpl<employee> implements EmployeeService {
    List<Employee> employee = new ArrayList<>(Arrays.asList(
            new Employee("Lex", "Lutor"),
            new Employee("Lois", "Laine"),
            new Employee(null, null),
            new Employee("Clark", "Kent"),
            new Employee("Oliver", "Queen"),
            new Employee("Viktor", "Stone"),
            new Employee(null, null)
    ));
    HashMap<String, Employee> mapEmploye = new HashMap<>();

//Заполнили мапу
    public  void init() {
        for(Employee emp :employee){
            mapEmploye.put(emp.getName()+emp.getLastName(),emp);
        }
    }




    public Employee getEmployee(int number) {
        if (number >= employee.size()) {
            throw new FindException();
        }
        return employee.get(number);
    }


    public int search(String name, String lastname) {
        mapEmploye.get(name+lastname);
        for (int i = 0; i < employee.size(); i++) {
            if ((employee.get(i) != null) && (employee.get(i).getName() != null)) {//if1
                Employee employe = new Employee(name, lastname);
                if (employe.equals(employee.get(i))) return i;
            }//if1
        }//for
        return employee.size();
    }

    public Employee add(String name, String lastName) {
        Employee employe = new Employee(name, lastName);
        if(mapEmploye.containsKey(name+lastName)) throw new AddExceptionBadReques();
        mapEmploye.put(name+lastName,employe);
            return employe;

    }

    public Employee remove(String name, String lastName) {
        if(!mapEmploye.containsKey(name+lastName)) throw new RemoveException();
        Employee tmp = mapEmploye.get(name+lastName);
        mapEmploye.remove(name+lastName);
            return tmp;
        }





    public Employee find(String name, String lastName) {
        if(!mapEmploye.containsKey(name+lastName)) throw new FindException();
            return mapEmploye.get(name+lastName);
        }




    @Override
    public HashMap<String,Employee> maplistEmployee() {
        return mapEmploye;
    }
}