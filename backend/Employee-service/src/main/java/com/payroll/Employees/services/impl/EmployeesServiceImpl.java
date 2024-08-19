package com.payroll.Employees.services.impl;

import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.LoginDto;
import com.payroll.Employees.dto.LoginRequestDto;
import com.payroll.Employees.entity.EmployeeRole;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.entity.Login;
import com.payroll.Employees.enums.Role;
import com.payroll.Employees.exceptions.EmployeeAlreadyExistException;
import com.payroll.Employees.exceptions.ResourceNotFoundException;
import com.payroll.Employees.mapper.EmployeesMapper;
import com.payroll.Employees.repository.EmployeeRepository;
import com.payroll.Employees.repository.EmployeeRoleRepository;
import com.payroll.Employees.repository.LoginRepository;
import com.payroll.Employees.services.IEmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeesServiceImpl implements IEmployeesService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeRoleRepository employeeRoleRepository;
    private final LoginRepository loginRepository;

    @Override
    public void createEmployee(EmployeesDto employeesDto) {
        Optional<Employees> foundEmployee = employeeRepository.findByMobileNumber(employeesDto.getMobileNumber());
        if(foundEmployee.isPresent()){
            throw new EmployeeAlreadyExistException("Employee already exists for this mobile number" + employeesDto.getMobileNumber());

        }

        Employees newEmployee = EmployeesMapper.mapToEmployee(employeesDto,new Employees());
        employeeRepository.save(newEmployee);

        for(Role role: employeesDto.getEmployeeRoles()){
            employeeRoleRepository.save(new EmployeeRole(newEmployee.getEmployeeId(), role));
        }
    }

    @Override
    public EmployeesDto getEmployeeById(Long employeeId) {
       Employees foundEmployee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(
               ()-> new ResourceNotFoundException("Employee","EmployeeId",employeeId.toString())
       );
       EmployeesDto foundEmployeeDto = EmployeesMapper.mapToEmployeesDto(foundEmployee,new EmployeesDto());
        List<EmployeeRole> employeeRoleList= employeeRoleRepository.findAllByEmployeeId(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "EmployeeId", employeeId.toString())
        );
        List<Role> roleList = employeeRoleList.stream().map(EmployeeRole::getRole).toList();
        foundEmployeeDto.setEmployeeRoles(roleList);
        return foundEmployeeDto;
    }

    @Override
    public Boolean updateEmployee(Long employeeId, EmployeesDto employeesDto) {
        Employees foundEmployee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","EmployeeId",employeeId.toString())
        );
        Employees updatedEmployee = EmployeesMapper.mapToEmployee(employeesDto,new Employees());
        employeeRepository.save(updatedEmployee);
        return Boolean.TRUE;

    }

    @Override
    public Boolean deleteEmployee(Long employeeId) {
        boolean isDeleted = false;
        Employees foundEmployee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","EmployeeId",employeeId.toString())
        );
        if(foundEmployee != null){
            employeeRepository.deleteById(employeeId);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public LoginDto login(LoginRequestDto loginRequestDto) {
        Login employee = loginRepository.findByEmployeeId(loginRequestDto.getEmployeeId()).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "EmployeeId", loginRequestDto.getEmployeeId().toString())

        );
        if(employee.getPassword().equals(loginRequestDto.getPassword())){
            List<EmployeeRole> employeeRoleList= employeeRoleRepository.findAllByEmployeeId(loginRequestDto.getEmployeeId()).orElseThrow(
                    ()-> new ResourceNotFoundException("Employee", "EmployeeId", loginRequestDto.getEmployeeId().toString())
            );

            List<Role> roleList = employeeRoleList.stream().map(EmployeeRole::getRole).toList();
            return new LoginDto(loginRequestDto.getEmployeeId(), roleList);
        }
        return null;
    }
}
