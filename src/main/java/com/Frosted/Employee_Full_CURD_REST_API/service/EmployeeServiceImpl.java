package com.Frosted.Employee_Full_CURD_REST_API.service;

import com.Frosted.Employee_Full_CURD_REST_API.DataJPA.EmployeeRepository;
import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employee;
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
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        Optional<Employee> results = employeeRepository.findById(id);
        Employee theEmployee = null;
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
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    //While using data jpa transaction will be managed by Spring Data JPA
//  @Transactional
    public void deleteEmployeeByID(int id) {
        employeeRepository.deleteById(id);
    }
}
