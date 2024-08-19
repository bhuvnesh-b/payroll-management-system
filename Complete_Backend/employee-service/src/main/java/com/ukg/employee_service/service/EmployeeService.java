package com.ukg.employee_service.service;

import com.ukg.employee_service.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Long employeeId, Employee employee);
    public void deleteEmployee(Long employeeId);
    public Employee addPayrollIdByEmployeeId(Long employeeId, Long payrollId);
    public boolean existsById(Long employeeId);


}
