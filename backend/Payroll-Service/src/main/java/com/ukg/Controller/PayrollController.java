package com.ukg.Controller;

import com.ukg.Service.PayrollServiceImp;
import com.ukg.Service.client.EmployeeFeignClient;
import com.ukg.Service.client.LeaveFeignClient;
import com.ukg.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class PayrollController {
    @Autowired
    private PayrollServiceImp payrollServiceImp;
    @Autowired
    private LeaveFeignClient leaveFeignClient;
    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    @PostMapping("/generate")
    public ResponseEntity<ReportDataDto> generateReport(@RequestBody ReportDto reportDto) {
        ReportDataDto reportData = payrollServiceImp.generateReport(reportDto);
        if (reportData != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(reportData);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateSalary(@RequestBody SalaryDto salaryDto)
    {
        boolean isUpdated = payrollServiceImp.updateSalary(salaryDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("204", "Updated successfully"));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto("500", "Internal Server Error"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam Long employeeId) {
        boolean isDeleted = payrollServiceImp.deleteAccount(employeeId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("204" , "Deleted Successfully"));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto("500" , "Internal Server Error"));
        }
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeFeignClient.getAllEmployeeData().getBody());
    }

    @GetMapping("/getEmployeeDetails/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeDetails(@PathVariable Long employeeId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeFeignClient.getEmployeeById(employeeId).getBody());
    }

    @GetMapping("/fetchleaves")
    public ResponseEntity<LeaveDto> fetchLwp(@RequestParam Long employeeId , @RequestParam Long startMonth , @RequestParam Long endMonth){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(leaveFeignClient.fetchLeave(employeeId, startMonth, endMonth).getBody());
    }

    @GetMapping("/getsalary")
    public ResponseEntity<SalaryDto>getSalary(@RequestParam Long employeeId)
    {
        SalaryDto salaryDto= payrollServiceImp.getSalary(employeeId);
        return   ResponseEntity.status(HttpStatus.OK).body(salaryDto);
    }
}
