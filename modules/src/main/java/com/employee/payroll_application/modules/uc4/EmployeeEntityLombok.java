package com.employee.payroll_application.modules.uc4;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntityLombok {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty or null")  // Prevent empty/null values
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name should contain only alphabets and spaces") // Only letters and spaces allowed
    private String name;

    private double salary;
}
