package com.ukg.leave_service.controller;

import com.ukg.leave_service.model.Leave;
import com.ukg.leave_service.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @PostMapping("/{employeeId}")
    public ResponseEntity<Leave>  newPayroll(@RequestBody Leave leaves, @PathVariable Long employeeId){
        Leave leaves1=leaveService.addLeavesByEmployeeId(employeeId,leaves);
        return new ResponseEntity<>(leaves1, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Leave> getLeaveByEmployeeId(@PathVariable Long employeeId){
        return new ResponseEntity<>(leaveService.getLeaveByEmployeeId(employeeId), HttpStatus.OK);
    }
}
