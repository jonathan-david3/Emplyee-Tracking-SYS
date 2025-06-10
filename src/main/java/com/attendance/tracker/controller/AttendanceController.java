package com.attendance.tracker.controller;

import com.attendance.tracker.model.Attendance;
import com.attendance.tracker.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public Attendance markAttendance(@RequestParam Long employeeId, @RequestParam String status) {
        return attendanceService.markAttendance(employeeId, status);
    }

    @GetMapping("/employee/{id}")
    public List<Attendance> getEmployeeAttendance(@PathVariable Long id) {
        return attendanceService.getAttendanceByEmployee(id);
    }

    // New endpoint for department-wise attendance summary
    @GetMapping("/department-summary")
    public List<Object[]> getDepartmentAttendanceSummary() {
        return attendanceService.getAttendanceSummaryByDepartment();
    }
}
