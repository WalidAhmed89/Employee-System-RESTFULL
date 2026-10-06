package com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO_Impl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAO_Impl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employees", Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }


    @Override
    public void deleteEmployeeByID(int id) {
        Employee theEmployee = entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }
}
