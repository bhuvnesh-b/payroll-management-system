package com.ukg.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String designation;
    private String department;
    private Long managerId;
}
