package com.ukg.leave_service.service;

import com.ukg.leave_service.model.Leave;

public interface LeaveService {
    public Leave getLeaveByEmployeeId(Long employeeId);
    public Leave addLeavesByEmployeeId(Long employeeId, Leave leave);
}
