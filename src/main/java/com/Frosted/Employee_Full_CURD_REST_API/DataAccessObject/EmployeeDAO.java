package com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;

import java.util.List;

public interface EmployeeDAO {
    List<Employees> findAllEmployees();
    Employees getEmployeeByID(int id);
    void addEmployee(Employees employee);
    void updateEmployee();
    void deleteEmployeeByID(int id);
}
