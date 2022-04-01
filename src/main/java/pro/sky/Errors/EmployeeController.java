package pro.sky.Errors;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Errors.Exception.ParamsException;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeServise) {
        this.employeeService = employeeServise;
    }

    @GetMapping(path = "/find")
    Employee search(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastname", required = false) String lastName)  {
        if ((name == null) || (lastName == null)) {
            throw new ParamsException();
        }
        return employeeService.find(name, lastName);
    }

    @GetMapping(path = "/person")
    Employee person(@RequestParam("number") int number) {

        return employeeService.getEmployee(number);
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastname", required = false) String lastName) {
        if ((name == null) || (lastName == null)) {
            throw new ParamsException();
        }
        return employeeService.add(name, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee delete(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastname", required = false) String lastName) {
        if ((name == null) || (lastName == null)) {
            throw new ParamsException();
        }
        return employeeService.remove(name, lastName);
    }
}