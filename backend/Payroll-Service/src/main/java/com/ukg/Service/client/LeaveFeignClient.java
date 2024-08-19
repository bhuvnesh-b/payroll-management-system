package com.ukg.Service.client;

import com.ukg.dto.LeaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface LeaveFeignClient {
    @GetMapping("/leave/fetchleave")
    public ResponseEntity<LeaveDto> fetchLeave(@RequestParam Long employeeId , @RequestParam Long startMonth , @RequestParam Long endMonth);
}
