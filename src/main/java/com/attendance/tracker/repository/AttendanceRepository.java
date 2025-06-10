package com.attendance.tracker.repository;

import com.attendance.tracker.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployeeId(Long employeeId);

    @Query("SELECT e.department AS department, a.status AS status, COUNT(a) AS count " +
            "FROM Attendance a JOIN Employee e ON a.employeeId = e.employeeId " +
            "GROUP BY e.department, a.status")
    List<Object[]> getAttendanceSummaryByDepartment();
}

