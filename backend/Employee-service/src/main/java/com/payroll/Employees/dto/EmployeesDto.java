package com.payroll.Employees.dto;

import com.payroll.Employees.enums.Role;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String designation;
    private String mobileNumber;
    private List<Role> employeeRoles;


}