package com.netcracker.springboot;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * Created by akba0717 on 10-11-2017.
 */

@Entity
public class Employee {
    @Id
    private String empid;
    private String name;
    private String department;


    public Employee() {
    }

    public Employee(String empid, String name, String department) {
        super();
        this.empid = empid;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }
}
