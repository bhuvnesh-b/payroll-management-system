package com.ukg.employee_service.service;

import com.ukg.employee_service.exception.ResourceNotFoundException;
import com.ukg.employee_service.model.Employee;
import com.ukg.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not FOund"));
    }

    @Override
    public Employee addEmployee(Employee employee){
//         employee.setPayrollIds(new ArrayList<Long>());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employeeDetails){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Element Not Found"));
        employee.setFirstName(employeeDetails.getFirstName()!=null ? employeeDetails.getFirstName():employee.getFirstName());
        employee.setLastName(employeeDetails.getLastName()!=null ? employeeDetails.getLastName():employee.getLastName());
        employee.setSalary(employeeDetails.getSalary());
        employee.setPayrollIds(employeeDetails.getPayrollIds());
        employee.setLeaves(employeeDetails.getLeaves());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId){
        if(!employeeRepository.existsById(employeeId)){
            throw new ResourceNotFoundException("Employee Not Found");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee addPayrollIdByEmployeeId(Long employeeId, Long payrollId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Element Not Found"));
        employee.getPayrollIds().add(payrollId);
        return employeeRepository.save(employee);
    }

    @Override
    public boolean existsById(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }


}
