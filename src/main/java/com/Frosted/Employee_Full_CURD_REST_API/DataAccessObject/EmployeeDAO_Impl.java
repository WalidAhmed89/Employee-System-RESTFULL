package com.Frosted.Employee_Full_CURD_REST_API.DataAccessObject;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employees;
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
    public List<Employees> findAllEmployees() {
        TypedQuery<Employees> theQuery = entityManager.createQuery("FROM Employees", Employees.class);

        return theQuery.getResultList();
    }

    @Override
    public Employees getEmployeeByID(int id) {
        return entityManager.find(Employees.class, id);
    }

    @Override
    @Transactional
    public void addEmployee(Employees employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public void updateEmployee() {

    }

    @Override
    @Transactional
    public void deleteEmployeeByID(int id) {

    }
}
