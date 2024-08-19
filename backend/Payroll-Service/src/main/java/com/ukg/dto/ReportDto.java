package com.ukg.dto;

import lombok.Data;

@Data
public class ReportDto {
    private long employeeId;
    private String firstName;
    private String lastName;
    private Long startMonth;
    private Long endMonth;
}
