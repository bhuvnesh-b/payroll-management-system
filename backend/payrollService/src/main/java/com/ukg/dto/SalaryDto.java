package com.ukg.dto;

import lombok.Data;

@Data
public class SalaryDto {
    private long employeeId;
    private long baseSalary;
    private long hra;
    private long allowance;
    private long deduction;
}
