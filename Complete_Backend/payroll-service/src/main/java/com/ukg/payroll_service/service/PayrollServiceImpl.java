package com.ukg.payroll_service.service;

import com.ukg.payroll_service.Client.EmployeeClient;
import com.ukg.payroll_service.exception.ResourceNotFoundException;
import com.ukg.payroll_service.model.Employee;
import com.ukg.payroll_service.model.Payroll;
import com.ukg.payroll_service.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PayrollServiceImpl implements PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @Override
    public List<Payroll> getAllPayrolls()
    {
        return payrollRepository.findAll();
    }

    @Override
    public Payroll getPayrollByEmployeeIdAndPayPeriod(Long employeeId, String payPeriod) {
        return payrollRepository.findByEmployeeIdAndPayPeriod(employeeId,payPeriod);
    }

    @Override
    public List<Payroll> getPayrollByEmployeeId(Long employeeId) {
        if(!employeeClient.employeeExistsById(employeeId)){
            throw new ResourceNotFoundException("Employee id number: "+employeeId +" does not exist");
        }
        return payrollRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Payroll addPayroll(Long employeeId, Payroll payroll) {

        Employee employee = employeeClient.getEmployeeById1(employeeId);
        Double grossPay =employee.getSalary()*0.80;
        Double netPay=grossPay*0.80;
        payroll.setGrossPay(grossPay);
        payroll.setNetPay(netPay);
        payroll.setEmployeeId(employeeId);
        Payroll newPayroll = payrollRepository.save(payroll);
        employee.getPayrollIds().add(newPayroll.getId());
        employeeClient.updateEmployeeById(employeeId,employee);
        return newPayroll;
    }

    @Override
    public Payroll updatePayroll(Long payrollId, Payroll payrollDetails) {
        Payroll p=payrollRepository.findById(payrollId).orElseThrow(()->new ResourceNotFoundException("Employee does not exist with this payrollId"));
        p.setGrossPay(!Double.isNaN(payrollDetails.getGrossPay())?payrollDetails.getGrossPay():p.getGrossPay());
        p.setNetPay(!Double.isNaN(payrollDetails.getNetPay())?payrollDetails.getNetPay():p.getNetPay());
        return payrollRepository.save(p);
    }

}

