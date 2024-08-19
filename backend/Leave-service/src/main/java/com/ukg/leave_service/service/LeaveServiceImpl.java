package com.ukg.leave_service.service;

import com.ukg.leave_service.client.EmployeeClient;
import com.ukg.leave_service.exception.ResourceNotFoundException;
//import com.ukg.leave_service.model.Employee;
import com.ukg.leave_service.model.Employee;
import com.ukg.leave_service.model.Leave;
//import com.ukg.leave_service.model.Payroll;
//import com.ukg.leave_service.repository.EmployeeRepository;
import com.ukg.leave_service.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private EmployeeClient employeeClient;


    @Override
    public Leave getLeaveByEmployeeId(Long employeeId) {
        return leaveRepository.getLeavesByEmployeeId(employeeId);
    }

    @Override
    public Leave addLeavesByEmployeeId(Long employeeId, Leave leave) {
        Employee employee =employeeClient.getEmployeeById1(employeeId);
        leave.setEmployeeId(employeeId);
        leave.setSickLeave(employee.getLeaves()*(0.25));
        leave.setCasualLeave(employee.getLeaves()*(0.75));
        return leaveRepository.save(leave);
    }
}
