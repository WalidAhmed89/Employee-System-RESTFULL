package com.Frosted.Employee_Full_CURD_REST_API.service;

import com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject.EmployeeDAO;
import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employees> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employees getEmployeeByID(int id) {
        return employeeDAO.getEmployeeByID(id);
    }

    @Override
    @Transactional
    public Employees save(Employees employee) {
        return employeeDAO.save(employee);
    }


    @Override
    @Transactional
    public void deleteEmployeeByID(int id) {
        employeeDAO.deleteEmployeeByID(id);
    }
}
