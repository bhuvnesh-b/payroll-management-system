package com.ukg.dto;

import lombok.Data;

@Data
public class ReportDataDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long paidLeaves;
    private Long unpaidLeaves;
    private Long baseSalary;
    private long hra;
    private long allowance;
    private long deduction;
    private long netSalary;
}
