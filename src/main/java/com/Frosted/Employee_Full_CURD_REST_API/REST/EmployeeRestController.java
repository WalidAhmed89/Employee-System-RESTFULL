package com.Frosted.Employee_Full_CURD_REST_API.REST;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employee;
import com.Frosted.Employee_Full_CURD_REST_API.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeDAO) {
        this.employeeService = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee SearchForEmployeeByID(@PathVariable int employeeID) {
        Employee theEmployee = employeeService.getEmployeeByID(employeeID);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){

        Employee theEmployee = employeeService.getEmployeeByID(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeID);
        }

        employeeService.deleteEmployeeByID(employeeID);
        return "Employee Delete that id :- "+employeeID;
    }
}
