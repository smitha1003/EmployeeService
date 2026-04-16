package com.example.api.employee.employeeservice.controller;

import com.example.api.employee.employeeservice.domain.Employee;
import com.example.api.employee.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * ...
 *
 * @author Smitha Kochunny
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee e){
        employeeService.save(e);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Employee e){
        Optional<Employee> existingEmp = employeeService.findById(e.getEmpId());
        if(existingEmp.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee with id {"+e.getEmpId()+"} not found");
        employeeService.save(e);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Employee get(@PathVariable("id") Long empId){
        Optional<Employee> existingEmp = employeeService.findById(empId);
        if(existingEmp.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee with id {"+empId+"} not found");
        return existingEmp.get();
    }

    @GetMapping("/sort/id")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> sortById(){
        return employeeService.sortById(employeeService.findAll());
    }

}
