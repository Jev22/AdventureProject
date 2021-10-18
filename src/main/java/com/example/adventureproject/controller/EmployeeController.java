package com.example.adventureproject.controller;


import com.example.adventureproject.model.Employee;
import com.example.adventureproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping(value="/employee", consumes = "application/json")
    public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
        System.out.println("Employee = " + employee);
        employeeRepository.save(employee);
        System.out.println("Done saving employee = " + employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    //Henter liste med alle employee
    @GetMapping("/employee")
    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }


    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Optional<Employee> obj = employeeRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        Employee employee = new Employee();
        employee.setEmployeeFirstName("Not Found");
        return employee;
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
        System.out.println("Delete kaldt employee Kode = " + id);
        try {
            employeeRepository.deleteById(id);
        } catch (Exception err) {
            return new ResponseEntity<>("employee ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee){
        System.out.println(employeeId);
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);
        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setEmployeeFirstName(employee.getEmployeeFirstName());
            _employee = employeeRepository.save(_employee);
            return new ResponseEntity<>(_employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
