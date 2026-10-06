package com.Frosted.Employee_Full_CURD_REST_API.service;

import com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject.EmployeeDAO;
import com.Frosted.Employee_Full_CURD_REST_API.DataJPA.EmployeeRepository;
import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // using Spring Data JPA
    private final EmployeeRepository employeeRepository;


    //using DAO
//    private final EmployeeDAO employeeDAO;
//
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }

    @Override
    public List<Employees> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees getEmployeeByID(int id) {
        Optional<Employees> results = employeeRepository.findById(id);
        Employees theEmployee = null;
        if(results.isPresent()){
            theEmployee =  results.get();
        }else{
            throw new RuntimeException("Did not find employee id - "+id);
        }
        return theEmployee;
    }

    @Override
    //While using data jpa transaction will be managed by Spring Data JPA
//  @Transactional
    public Employees save(Employees employee) {
        return employeeRepository.save(employee);
    }


    @Override
    //While using data jpa transaction will be managed by Spring Data JPA
//  @Transactional
    public void deleteEmployeeByID(int id) {
        employeeRepository.deleteById(id);
    }
}
