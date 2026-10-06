package com.Frosted.Employee_Full_CURD_REST_API.REST;

import com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject.EmployeeDAO;
import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;
import com.Frosted.Employee_Full_CURD_REST_API.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeDAO){
        this.employeeService = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employees> findAll(){
        return employeeService.findAllEmployees();
    }
}
