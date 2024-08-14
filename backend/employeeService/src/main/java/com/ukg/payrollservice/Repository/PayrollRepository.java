package com.ukg.payrollservice.Repository;

import com.ukg.payrollservice.Model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
