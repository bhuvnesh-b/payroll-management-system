package com.ukg.payrollservice.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "salary_structure")
public class Payroll {
    @Id
    @GeneratedValue
    private long payrollId;
    private long employeeId;
    private long baseSalary;
    private long hra;
    private long allowance;
    private long deduction;
    private LocalDate localDateTime;
}
