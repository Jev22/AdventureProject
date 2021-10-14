package com.example.adventureproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {



    @Id
    private int employeeId;
    private String employeeFirstName;
    private String employeeLastName;

    //Empty constructor
    public Employee(){}

    //Setters & Getters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }


}
