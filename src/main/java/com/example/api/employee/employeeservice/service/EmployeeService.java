package com.example.api.employee.employeeservice.service;

import com.example.api.employee.employeeservice.domain.Employee;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ...
 *
 * @author Smitha Kochunny
 */
@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1,"George", "Clooney","Infrastructure", "Specialist"),
            new Employee(2,"Brad", "Pitt","Security", "Manager"),
            new Employee(13,"Robert", "Patterson","Security", "Engineer"),
            new Employee(12,"Nicholas", "Cage","Infrastructure", "Engineer"),
            new Employee(5,"Liam", "Neeson","Infrastructure", "Analyst"),
            new Employee(11,"Julia", "Roberts","Infrastructure", "Engineer"),
            new Employee(4,"Nicole", "Kidman","Security", "Manager"),
            new Employee(9,"Marilyn", "Monroe","IT", "Specialist"),
            new Employee(3,"Anne", "Hathway","Security", "Specialist"),
            new Employee(20,"Emma", "Watson","Security", "Manager"),
            new Employee(6,"Angelina", "Joley","Infrastructure", "Manager"),
            new Employee(10,"Anna", "Kendrick","Security", "Analyst"),
            new Employee(8,"Sharon", "Stone","Security", "Engineer"),
            new Employee(17,"Demi", "More","Infrastructure", "Engineer"),
            new Employee(14,"Blake", "Lively","Infrastructure", "Engineer"),
            new Employee(19,"Jennifer", "Aniston","IT", "Engineer"),
            new Employee(15,"Cameron", "Diaz","IT", "Engineer"),
            new Employee(18,"Alexandra", "Dadario","IT", "Engineer")
            ));

    public List<Employee> findAll(){
        return employees;
    }

    public void save(Employee e){
        employees.add(e);
    }

    public Optional<Employee> findById(long id){
        return employees.stream().filter(e->e.getEmpId()==id).findFirst();
    }

    public List<Employee> findByDepartment(String department){
        return employees.stream().filter(e->e.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
    }

    public List<Employee> findByName(String firstName, String lastName){
        if(StringUtils.isBlank(firstName) && StringUtils.isBlank(lastName))
            throw new IllegalArgumentException("First Name or Last Name must be provided");
        boolean hasFirst = StringUtils.isNotBlank(firstName);
        boolean hasLast = StringUtils.isNotBlank(lastName);
        return employees.stream().filter(e->!hasFirst || e.getFirstName().equalsIgnoreCase(firstName)
                                                    && !hasLast || e.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Employee> findByDesignation(String designation){
        return employees.stream().filter(e->e.getDesignation().equalsIgnoreCase(designation)).collect(Collectors.toList());
    }

    public List<Employee> sortById(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparingLong(Employee::getEmpId)).collect(Collectors.toList());
    }

    public List<Employee> sortByDepartment(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
    }

    public List<Employee> sortByDesignation(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(Employee::getDesignation)).collect(Collectors.toList());
    }

    public List<Employee> sortByFirstName(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
    }

    public List<Employee> sortByLastName(List<Employee> employees){
        return employees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
    }
}
