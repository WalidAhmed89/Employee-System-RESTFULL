package com.Frosted.Employee_Full_CURD_REST_API.service;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAllEmployees();
    Employees getEmployeeByID(int id);
    void addEmployee(Employees employee);
    void updateEmployee();
    void deleteEmployeeByID(int id);
}
