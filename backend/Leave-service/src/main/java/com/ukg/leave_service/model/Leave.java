package com.ukg.leave_service.model;

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
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sick_leaves")
    private Double sickLeave;

    @Column(name = "casual_leaves")
    private  Double casualLeave;

    @Column(name="employeeId",nullable = false)
    private Long employeeId;
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="employee_id", referencedColumnName = "id")
//    private Employee employee;
}
