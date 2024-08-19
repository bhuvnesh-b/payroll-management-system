package com.ukg.leave_service.repository;

import com.ukg.leave_service.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long> {
    Leave getLeavesByEmployeeId(Long employeeId);
//    Leave addLeavesByEmployeeId(Long employeeId, Leave leave);
}
