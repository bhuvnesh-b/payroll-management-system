package com.payroll.Employees.services;

import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.LoginDto;
import com.payroll.Employees.dto.LoginRequestDto;

public interface IEmployeesService {
    void createEmployee(EmployeesDto employeesDto);

    EmployeesDto getEmployeeById(Long employeeId);

    Boolean updateEmployee(Long employeeId,EmployeesDto employeesDto);

    Boolean deleteEmployee(Long employeeId);

    LoginDto login(LoginRequestDto loginRequestDto);

}
