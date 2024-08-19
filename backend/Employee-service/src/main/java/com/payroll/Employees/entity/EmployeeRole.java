package com.payroll.Employees.entity;

import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="Emp_Role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRole {
    @Id
    @GeneratedValue
    private Long employeeRoleId;


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;


    @Column(name = "employee_id")
    private Long employeeId;


    public EmployeeRole(Long employeeId, Role role) {
        setEmployeeId(employeeId);
        setRole(role);
    }


}
