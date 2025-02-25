package com.employee.payroll_application.modules.uc4;

// using lombok to prevent boiler plate code
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntityLombok {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;


}
