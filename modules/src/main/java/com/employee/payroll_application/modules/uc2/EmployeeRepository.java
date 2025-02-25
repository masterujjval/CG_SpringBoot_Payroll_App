package com.employee.payroll_application.modules.uc2;

import com.employee.payroll_application.modules.uc4.EmployeeEntityLombok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntityLombok, Long> {
}
