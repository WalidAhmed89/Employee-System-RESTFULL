package com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;

import java.util.List;

public interface EmployeeDAO {
    List<Employees> findAllEmployees();
    Employees getEmployeeByID(int id);
    Employees save(Employees employee);
    void deleteEmployeeByID(int id);
}
