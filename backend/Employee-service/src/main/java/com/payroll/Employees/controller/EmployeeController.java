package com.payroll.Employees.controller;
import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.LoginDto;
import com.payroll.Employees.dto.LoginRequestDto;
import com.payroll.Employees.dto.ResponseDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.mapper.EmployeesMapper;
import com.payroll.Employees.services.IEmployeesService;
import com.payroll.Employees.services.impl.EmployeesServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
//    private final EmployeesServiceImpl employeesService;
    private final IEmployeesService iEmployeesService;

    @GetMapping("/ping")
    public ResponseEntity<String > Ping(){
        return ResponseEntity.status(HttpStatus.OK).body("Server is up!!");
    }

    public EmployeeController(IEmployeesService iEmployeesService) {
        this.iEmployeesService = iEmployeesService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@RequestBody EmployeesDto employeesDto) {
        iEmployeesService.createEmployee(employeesDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(" Created Successfully Created", HttpStatus.CREATED));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeesDto> getEmployeeId(@PathVariable Long employeeId){
        EmployeesDto employeeDto = iEmployeesService.getEmployeeById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginDto loginDto= iEmployeesService.login(loginRequestDto);
        if(loginDto != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(loginDto);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(null);
    }


  @PutMapping("/update/{employeeId}")
  public ResponseEntity<ResponseDto> updateEmployee(@PathVariable Long employeeId,EmployeesDto employeesDto){
        boolean isUpdated = iEmployeesService.updateEmployee(employeeId,employeesDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Employee detail updated SuccessFully",HttpStatus.OK));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Failure to update the employee",HttpStatus.NOT_FOUND));
  }
  @DeleteMapping("/delete/{employeeId}")
    public  ResponseEntity<ResponseDto> deleteEmployee(@PathVariable Long employeeId){
        boolean isDeleted = iEmployeesService.deleteEmployee(employeeId);
        if(isDeleted){
            return ResponseEntity.status((HttpStatus.OK)).body(new ResponseDto("Deleted Successfully",HttpStatus.OK));
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR));
        }
  }
}

