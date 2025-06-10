package com.attendance.tracker.service;

import com.attendance.tracker.model.Attendance;
import com.attendance.tracker.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance markAttendance(Long employeeId, String status) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(status);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByEmployee(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    // New method for department-wise attendance summary
    public List<Object[]> getAttendanceSummaryByDepartment() {
        return attendanceRepository.getAttendanceSummaryByDepartment();
    }
}
