package com.example.adventureproject.repository;

import com.example.adventureproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeeByEmployeeId(String employeeId);


}


