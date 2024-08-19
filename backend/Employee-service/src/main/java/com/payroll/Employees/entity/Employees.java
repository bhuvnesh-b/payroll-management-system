package com.payroll.Employees.entity;

import com.payroll.Employees.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String designation;
    private String mobileNumber;

}
