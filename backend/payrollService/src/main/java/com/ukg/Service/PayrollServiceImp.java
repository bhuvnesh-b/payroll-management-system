package com.ukg.Service;

import com.ukg.dto.ReportDto;
import com.ukg.dto.SalaryDto;
import com.ukg.dto.ReportDataDto;

public interface PayrollServiceImp {

    boolean updateSalary(SalaryDto salary);

    boolean deleteAccount(Long employeeId);

    ReportDataDto generateReport(ReportDto reportDto);

    SalaryDto getSalary(Long employeeId);
}
