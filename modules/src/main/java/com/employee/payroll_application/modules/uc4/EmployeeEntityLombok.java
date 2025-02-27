package com.employee.payroll_application.modules.uc4;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class EmployeeEntityLombok {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long employeeId;
    @NotEmpty(message = "Name cannot be empty or null")  // Prevent empty/null values
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name should contain only alphabets and spaces") // Only letters and spaces allowed
    private String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    private double salary;
    private String gender;
    private LocalDate startDate;
    public String note;
    private String profilePic;
    private List<String>departments;


}
