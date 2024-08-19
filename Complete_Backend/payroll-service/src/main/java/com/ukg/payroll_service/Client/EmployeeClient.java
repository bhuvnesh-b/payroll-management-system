package com.ukg.payroll_service.Client;

import com.ukg.payroll_service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
    @GetMapping("/api/employees/{employeeId}")
    public Employee getEmployeeById1( @PathVariable Long employeeId);
    @PostMapping("/api/employees/payroll/{employeeId}/{payrollId}")
    public void addPayrollIdByEmployeeId(@PathVariable Long employeeId, @PathVariable Long payrollId);
    @GetMapping("/api/employees/employeeExist/{employeeId}")
    public boolean employeeExistsById(@PathVariable Long employeeId);
    @PostMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee);
}
