package com.ukg.payrollservice.Repository;

import com.ukg.payrollservice.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report , Long> {
}
