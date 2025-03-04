package com.employee.payroll_application.modules.uc3;
import com.employee.payroll_application.modules.uc2.EmployeeEntity;
import com.employee.payroll_application.modules.uc2.EmployeeRepository;
import com.employee.payroll_application.modules.uc4.EmployeeEntityLombok;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntityLombok> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // find by id
    public EmployeeEntityLombok getEmployeeById(Long id){

        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee ID not found!!"));

    }

    // create emplyees
    public EmployeeEntityLombok createEmployee(@Valid @RequestBody EmployeeEntityLombok emp){
        return employeeRepository.save(emp);
    }

    // for updating the employee record in the database

    public EmployeeEntityLombok updateEmployee(Long id, @Valid @RequestBody EmployeeEntityLombok updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());

           
            employee.getDepartments().clear();
            employee.getDepartments().addAll(updatedEmployee.getDepartments());

            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }



    //delete record
    public String deleteEmployee( Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully.";
    }




}
