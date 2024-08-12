package com.ukg.payrollservice.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "salary_structure")
public class SalaryStructure {
    @Id
    @GeneratedValue
    @Column(name = "salary_struct_id")
    private Long id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "basic_salary")
    private double basicSalary;

    @Column(name = "allowance")
    private double allowance;
}
