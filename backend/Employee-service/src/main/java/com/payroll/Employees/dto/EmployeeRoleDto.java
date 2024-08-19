package com.payroll.Employees.dto;

import com.payroll.Employees.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRoleDto {
    private Long employeeId;
    private Role role;
}
