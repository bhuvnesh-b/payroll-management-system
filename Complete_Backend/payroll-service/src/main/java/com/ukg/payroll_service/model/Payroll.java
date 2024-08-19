package com.ukg.payroll_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payroll")
@Getter
@Setter
@EqualsAndHashCode
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name="gross_pay")
    private double grossPay;

    @Column(name="net_pay")
    private double netPay;

    @Column(name="pay_period")
    private  String payPeriod;

    @Column(name="employeeId", nullable = false)
    private long employeeId;
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="employee_id", referencedColumnName = "id")
//    private Employee employee;

}
