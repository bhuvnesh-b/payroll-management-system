package com.ukg.payroll_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private double salary;
    private List<Long> payrollIds;
    private Double leaves;
}
