package com.ukg.employee_service.controller;

import com.ukg.employee_service.model.Employee;
import com.ukg.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> newEmployee(@RequestBody @Valid Employee newEmployee){
        Employee employee =employeeService.addEmployee(newEmployee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee =employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById1(@PathVariable Long id){
        Employee employee =employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping("/payroll/{employeeId}/{payrollId}")
    public Employee addPayrollIdByEmployeeId(@PathVariable Long employeeId, @PathVariable Long payrollId){
        return employeeService.addPayrollIdByEmployeeId(employeeId,payrollId);
    }

    @GetMapping("/employeeExist/{employeeId}")
    public boolean employeeExistsById(@PathVariable Long employeeId){
        return employeeService.existsById(employeeId);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/payroll/{employeeId}/{payrollId}")
//    public ResponseEntity<Employee> addPayrollIdByEmployeeId(@PathVariable long employeeId, @PathVariable long payrollId){
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        employee.getPayrollIds().add(payrollId);
//        return new ResponseEntity<>(employeeService.updateEmployee(employeeId,employee),HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(id,employee);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

}
