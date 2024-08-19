package com.ukg.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "salary_structure")
public class Salary {
    @Id
    @GeneratedValue
    private long salaryId;
    private long employeeId;
    private long baseSalary;
    private long hra;
    private long allowance;
    private long deduction;
    private LocalDate lastUpdated;
}
