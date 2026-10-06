package com.Frosted.Employee_Full_CURD_REST_API.service;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAllEmployees();
    Employees getEmployeeByID(int id);
    Employees save(Employees employee);
    void deleteEmployeeByID(int id);
}
