package com.ukg.employee_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "first_name", nullable = false)
    private String firstName;

    @Column(name= "last_name", nullable = false)
    private String lastName;

    @Column(name="Salary",nullable = false)
    @Min(value = 1000, message = "Invalid Salary: Low Than Minimum Salary")
    @Max(value = 1000000, message = "Invalid Salary: Higher Than Maximum Salary")
    private double salary;

    private List<Long> payrollIds;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
//    private List<Payroll> payrollList;

    @Column(name = "Leaves",nullable = false)
    private Double leaves;

}
