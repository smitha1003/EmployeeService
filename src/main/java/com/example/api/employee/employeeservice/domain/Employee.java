package com.example.api.employee.employeeservice.domain;

/**
 * ...
 *
 * @author Smitha Kochunny
 */

public class Employee {
    private long empId;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;

    public Employee(long empId, String firstName, String lastName, String department, String designation) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.designation = designation;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
