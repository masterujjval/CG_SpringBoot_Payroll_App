package com.employee.payroll_application.modules.uc1;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @RequestMapping("/api/payroll")
    public String apiPayroll(){
        return "Api Payroll is working";
    }
    @PostMapping("/api/payroll/post")
    public String apiPost(@RequestParam("name")String name, @RequestParam("salary")String salary){
        return "Name: "+name+"\nSalary: "+salary;
    }

    // put mapping
    @PutMapping("/api/payroll/put")
    public String apiPut(@RequestParam("name") String name, @RequestParam("salary") String salary) {
        return "Updated Name: " + name + "\nUpdated Salary: " + salary;
    }

    @DeleteMapping("/api/payroll/delete")
    public String apiDelete(@RequestParam("id")int id){
        return "Record Deleted Successfully";
    }

}
