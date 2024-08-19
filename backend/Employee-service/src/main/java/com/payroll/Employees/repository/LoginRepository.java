package com.payroll.Employees.repository;


import com.payroll.Employees.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmployeeId(Long employeeId);
}

