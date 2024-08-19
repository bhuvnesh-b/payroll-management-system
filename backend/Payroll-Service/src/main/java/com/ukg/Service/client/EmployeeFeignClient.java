package com.ukg.Service.client;


import com.ukg.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("Employee-Feign-client")
public interface EmployeeFeignClient {

    @GetMapping("/api/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId);

//    @GetMapping("/api/fetch-all")
//    public ResponseEntity<List<EmployeeDto>> getAllEmployeeData();
}
