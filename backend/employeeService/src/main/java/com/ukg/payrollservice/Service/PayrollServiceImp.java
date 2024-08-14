package com.ukg.payrollservice.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ukg.payrollservice.dto.ReportDto;
import com.ukg.payrollservice.dto.SalaryDto;

public interface PayrollServiceImp {

    boolean deleteAccount(Long employeeId);

    boolean updateSalary(SalaryDto salary);

    JsonNode generateReport(ReportDto reportDto);

    SalaryDto getSalary(Long employeeId);
}
