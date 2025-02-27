package com.employee.payroll_application.modules.uc4;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class EmployeeEntityLombok {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    @NotEmpty(message = "Name cannot be empty or null")  // Prevent empty/null values
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name should contain only alphabets and spaces") // Only letters and spaces allowed
    private String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    private double salary;
    private String gender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "start date should be past or todays date ")
    @NotNull(message = "Date should not be empty")
    private LocalDate startDate;
    @NotBlank(message = "Please fill the note")
    public String note;
    @NotBlank(message = "Enter profile pic address")
    private String profilePic;
    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns = @JoinColumn(name = "id"))
    @NotNull(message = "Department should not be null")
    @Column(name = "department")
    private List<String>departments;


}
