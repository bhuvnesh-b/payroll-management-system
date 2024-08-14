package com.ukg.payrollservice.dto;

import lombok.Data;

@Data
public class ReportDto {
    private long employeeId;
    private String employeeName;
    private String startDate;
    private String endDate;
}
