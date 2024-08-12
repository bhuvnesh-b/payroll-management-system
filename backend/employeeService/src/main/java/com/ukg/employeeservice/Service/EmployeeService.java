package com.ukg.employeeservice.Service;

import com.ukg.employeeservice.Model.EmployeeModel;
import com.ukg.employeeservice.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<EmployeeModel> getEmployeeById(Long Id){
        return employeeRepository.findById(Id);
    }
    public EmployeeModel createEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }
    public EmployeeModel updateEmployee(Long id,EmployeeModel employee){
        if(employeeRepository.existsById(id)){
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return  null;
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
