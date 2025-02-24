package com.employee.payroll_application.modules.uc2;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class EmployeeEntity {

    // creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String salary;

    // creating constructor
    public EmployeeEntity(){}

    public EmployeeEntity(String name, String salary){
        this.name=name;
        this.salary=salary;
    }
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }


}
