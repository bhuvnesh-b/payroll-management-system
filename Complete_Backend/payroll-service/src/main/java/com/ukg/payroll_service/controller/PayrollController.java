package com.ukg.payroll_service.controller;

import com.ukg.payroll_service.model.Payroll;
import com.ukg.payroll_service.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payroll")
public class PayrollController {

    @Autowired
    PayrollService payrollService;

//    @Autowired
//    EmployeeService employeeService;

    @PostMapping("/{employeeId}")
    public ResponseEntity<Payroll>  newPayroll(@RequestBody Payroll payroll, @PathVariable Long employeeId){
        Payroll payroll1=payrollService.addPayroll(employeeId,payroll);
        return new ResponseEntity<>(payroll1, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<Payroll>> getPayrollByEmployeeId(@PathVariable Long employeeId){
        return new ResponseEntity<>(payrollService.getPayrollByEmployeeId(employeeId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls(){
        return new ResponseEntity<>(payrollService.getAllPayrolls(),HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/{payPeriod}")
    public ResponseEntity<Payroll> getPayrollByEmployeeIdAndPayPeriod(@PathVariable Long employeeId,@PathVariable String payPeriod){
        return new ResponseEntity<>(payrollService.getPayrollByEmployeeIdAndPayPeriod(employeeId,payPeriod),HttpStatus.OK);
    }

}
