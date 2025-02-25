package com.employee.payroll_application.modules.uc1;

import com.employee.payroll_application.modules.uc2.EmployeeEntity;
import com.employee.payroll_application.modules.uc2.EmployeeRepository;
import com.employee.payroll_application.modules.uc3.EmployeeService;
import com.employee.payroll_application.modules.uc4.EmployeeEntityLombok;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeEntityLombok> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntityLombok getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeEntityLombok createEmployee(@Valid @RequestBody EmployeeEntityLombok employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeEntityLombok updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeEntityLombok updatedEmployee) {
        return employeeService.updateEmployee(id,updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
