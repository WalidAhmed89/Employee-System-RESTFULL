package com.Frosted.Employee_Full_CURD_REST_API.REST;

import com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject.EmployeeDAO;
import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;
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
    public List<Employees> findAll() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeID}")
    public Employees SearchForEmployeeByID(@PathVariable int employeeID) {
        Employees theEmployee = employeeService.getEmployeeByID(employeeID);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees theEmployee){
        theEmployee.setId(0);

        Employees dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employees updateEmployee(@RequestBody Employees theEmployee){

        Employees dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){

        Employees theEmployee = employeeService.getEmployeeByID(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeID);
        }

        employeeService.deleteEmployeeByID(employeeID);
        return "Employee Delete that id :- "+employeeID;
    }
}
