package com.ukg.payroll_service.service;

import com.ukg.payroll_service.model.Payroll;

import java.util.List;

public interface PayrollService {
    List<Payroll> getAllPayrolls();
    Payroll getPayrollByEmployeeIdAndPayPeriod(Long employeeId,String payPeriod);
    List<Payroll> getPayrollByEmployeeId(Long employeeId);
    Payroll addPayroll(Long employeeId, Payroll payroll);
    Payroll updatePayroll(Long payrollId, Payroll payrollDetails);
}
