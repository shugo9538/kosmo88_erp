package com.kosmo88.logistics_erp.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.hr.service.AttendanceService;

@SessionAttributes({"session", "id"})
@Controller
@RequestMapping(value = "/hr/attendance")
public class AttendanceController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    AttendanceService attendanceService;

    // 근태 조회
    @RequestMapping(value = "")
    public String attendanceManagement(HttpServletRequest req, HttpServletResponse res) {
        return "hr/attendanceManagement/attendanceManagement";
    }

    // 근태 입력
    @RequestMapping(value = "/insertAttendance")
    public String insertAttendance(HttpServletRequest req, HttpServletResponse res) {
        return "hr/attendanceManagement/insertAttendance";
    }

    // 출퇴근 기록부
    @RequestMapping(value = "/commutingRecords")
    public String commutingRecords(HttpServletRequest req, HttpServletResponse res) {
        return "hr/attendanceManagement/commutingRecords";
    }

    // 출퇴근 입력 화면
    @RequestMapping(value = "/insertCommute")
    public String insertCommute(HttpServletRequest req, HttpServletResponse res) {
        return "hr/attendanceManagement/insertCommute";
    }
}
