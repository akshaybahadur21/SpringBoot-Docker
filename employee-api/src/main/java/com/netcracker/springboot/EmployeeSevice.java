package com.netcracker.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by akba0717 on 10-11-2017.
 */
@Service
public class EmployeeSevice {

    @Autowired
    private EmployeeRepository employeeRepository;
/*
   List<Employee> employees= new ArrayList<>( Arrays.asList(new Employee("akba0717", "Akshay Bahadur","SDN/NFV"),
            new Employee("shsi0717","Shiwani Singh","SDN/NFV")));*/

    public List<Employee> getAllEmployees()
    {
        List<Employee> employees=new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
       // return employees;
    }

    public Employee getEmployee(String empid)
    {
       // return employees.stream().filter(t->t.getEmpid().equals(empid)).findFirst().get();
        return employeeRepository.findOne(empid);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        //employees.add(employee);
    }
}
