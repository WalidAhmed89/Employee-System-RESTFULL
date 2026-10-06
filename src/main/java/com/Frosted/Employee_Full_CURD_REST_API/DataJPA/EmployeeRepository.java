package com.Frosted.Employee_Full_CURD_REST_API.DataJPA;

import com.Frosted.Employee_Full_CURD_REST_API.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
