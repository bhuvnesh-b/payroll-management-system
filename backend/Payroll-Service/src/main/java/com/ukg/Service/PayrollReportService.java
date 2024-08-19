package com.ukg.Service;

import com.ukg.Mapper.SalaryMapper;
import com.ukg.Model.Salary;
import com.ukg.Repository.SalaryRepository;
import com.ukg.Service.client.EmployeeFeignClient;
import com.ukg.Service.client.LeaveFeignClient;
import com.ukg.dto.LeaveDto;
import com.ukg.dto.ReportDto;
import com.ukg.dto.SalaryDto;
import com.ukg.dto.ReportDataDto;
import com.ukg.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollReportService implements PayrollServiceImp{
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private LeaveFeignClient leaveFeignClient;
    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    @Override
    public boolean updateSalary(SalaryDto salaryDto){
        boolean salaryFound = false;
        Salary salary = salaryRepository.findById(salaryDto.getEmployeeId()).orElseThrow(
                () ->
                    new ResourceNotFoundException("salary" , " employeeId" , salaryDto.getEmployeeId())
        );

        if(salary != null) {
            Salary newSalary = SalaryMapper.mapToSalary(salaryDto);
            salaryRepository.save(newSalary);
            salaryFound = true;
        }

        return salaryFound;
    }

    @Override
    public boolean deleteAccount(Long employeeId) {
        boolean isDeleted = false;

        Salary salary = salaryRepository.findByEmployeeId(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Salary" , "employeeID" , employeeId)
        );
        if(salary != null) {
            salaryRepository.delete(salary);
            isDeleted = true;
        }

        return isDeleted;
    }

    @Override
    public ReportDataDto generateReport(ReportDto reportDto) {
        Salary salary = salaryRepository.findByEmployeeId(reportDto.getEmployeeId()).orElseThrow(
                () -> new ResourceNotFoundException("salary" , "employeeId" , reportDto.getEmployeeId())
        );


        if(salary != null) {
            LeaveDto leave = leaveFeignClient.fetchLeave(reportDto.getEmployeeId() , reportDto.getStartMonth() , reportDto.getEndMonth()).getBody();
            Long deduction = calculateDeduction(leave);

            Long period = reportDto.getEndMonth() - reportDto.getStartMonth();
            Long totalSalary = (salary.getBaseSalary() + salary.getAllowance() + salary.getHra())*period;
            Long netSalary = totalSalary - deduction;

            ReportDataDto reportData = new ReportDataDto();
            reportData.setEmployeeId(reportDto.getEmployeeId());;
            reportData.setFirstName(reportDto.getFirstName());
            reportData.setLastName(reportDto.getLastName());
            reportData.setPaidLeaves(leave.getPaidLeaves());
            reportData.setUnpaidLeaves(leave.getUnpaidLeaves());
            reportData.setBaseSalary(salary.getBaseSalary());
            reportData.setHra(salary.getHra());
            reportData.setAllowance(salary.getAllowance());
            reportData.setDeduction(deduction);
            reportData.setNetSalary(netSalary);

            return reportData;
        }
        return null;
    }

    @Override
    public SalaryDto getSalary(Long employeeId) {
        SalaryDto salaryDto = new SalaryDto();
        Salary salary = salaryRepository.findByEmployeeId(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("salary" , "employeeId" , employeeId)
        );
        if(salary != null) {
            salaryDto = SalaryMapper.mapToSalaryDto(salary);
        }
        return salaryDto;
    }


    private Long calculateDeduction(LeaveDto leave) {
        Long totalUnpaidLeaves = leave.getUnpaidLeaves();
        if(leave.getPaidLeaves() > 50) {
            totalUnpaidLeaves += (leave.getPaidLeaves() - 50);
        }

        return totalUnpaidLeaves * 3000;
    }
}
