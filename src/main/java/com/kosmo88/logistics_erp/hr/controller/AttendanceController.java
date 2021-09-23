package com.kosmo88.logistics_erp.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.hr.service.HRService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr/attendance")
public class AttendanceController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    HRService hrService;
    
    // 근태 조회
    @RequestMapping(value = "/selectAttendacne")
    public String selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        hrService.selectAttendacne(req, res);
        
        return "hr/attendanceManagement";
    }
    
    // 근태 입력
    @RequestMapping(value = "/insertAttendance")
    public String insertAttendance(HttpServletRequest req, HttpServletResponse res) {
        hrService.insertAttendance(req, res);
        
        return "hr/attendanceManagement";
    }
    
    // 근태 현황
    @RequestMapping(value = "/attendanceStatus")
    public String attendanceStatus(HttpServletRequest req, HttpServletResponse res) {
        hrService.attendanceStatus(req, res);
        
        return "hr/attendanceManagement";
    }
    
    // 출퇴근 기록부
    @RequestMapping(value = "/commutingRecords")
    public String commutingRecords(HttpServletRequest req, HttpServletResponse res) {
        hrService.commutingRecords(req, res);
        
        return "hr/attendanceManagement";
    }
}
