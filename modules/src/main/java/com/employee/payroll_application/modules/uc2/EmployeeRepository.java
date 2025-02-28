package com.employee.payroll_application.modules.uc2;

import com.employee.payroll_application.modules.uc4.EmployeeEntityLombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntityLombok, Long> {
    @Query("SELECT e FROM EmployeeEntityLombok e JOIN e.departments d WHERE d = :departmentName")
    List<EmployeeEntityLombok> findEmployeesByDepartment(@Param("departmentName") String department);

}
