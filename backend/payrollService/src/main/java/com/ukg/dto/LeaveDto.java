package com.ukg.dto;

import lombok.Data;

@Data
public class LeaveDto {
    private long paidLeaves;
    private long unpaidLeaves;
    private long employeeId;
}
