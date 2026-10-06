package com.Frosted.Employee_Full_CURD_REST_API.service;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee getEmployeeByID(int id);
    Employee save(Employee employee);
    void deleteEmployeeByID(int id);
}
