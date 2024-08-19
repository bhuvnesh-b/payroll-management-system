package com.ukg.Mapper;

import com.ukg.Model.Salary;
import com.ukg.dto.SalaryDto;

public class SalaryMapper {
    public static Salary mapToSalary(SalaryDto salaryDto) {
        Salary salary = new Salary();
        salary.setEmployeeId(salaryDto.getEmployeeId());
        salary.setBaseSalary(salaryDto.getBaseSalary());
        salary.setHra(salaryDto.getHra());
        salary.setAllowance(salaryDto.getAllowance());
        salary.setDeduction(salary.getDeduction());

        return salary;
    }

    public static SalaryDto mapToSalaryDto(Salary salary) {
        SalaryDto salaryDto = new SalaryDto();
        salaryDto.setEmployeeId(salary.getEmployeeId());
        salaryDto.setBaseSalary(salary.getBaseSalary());
        salaryDto.setHra(salary.getHra());
        salaryDto.setAllowance(salary.getAllowance());
        salaryDto.setDeduction(salary.getDeduction());

        return salaryDto;
    }
}
