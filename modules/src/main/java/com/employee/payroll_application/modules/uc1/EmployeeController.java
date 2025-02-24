package com.employee.payroll_application.modules.uc1;

import com.employee.payroll_application.modules.uc2.EmployeeEntity;
import com.employee.payroll_application.modules.uc2.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully.";
    }
}
