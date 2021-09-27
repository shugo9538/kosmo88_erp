package com.kosmo88.logistics_erp.hr.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.service.AttendanceService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr/attendance")
public class AttendanceController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    AttendanceService attendanceService;
    
    // 근태 조회
    @RequestMapping(value = "")
    public String attendanceManagement(HttpServletRequest req, HttpServletResponse res) {
        return "hr/attendanceManagement";
    }
    
    // 근태 입력
    @RequestMapping(value = "/insertAttendance")
    public String insertAttendance(HttpServletRequest req, HttpServletResponse res) {
        
        return "hr/insertAttendance";
    }
    
    // 근태 현황
    @RequestMapping(value = "/attendanceStatus")
    public String attendanceStatus(HttpServletRequest req, HttpServletResponse res) {
        attendanceService.attendanceStatus(req, res);
        
        return "hr/attendanceManagement";
    }
    
    // 출퇴근 기록부
    @RequestMapping(value = "/commutingRecords")
    public ArrayList<CommuteDTO> commutingRecords(HttpServletRequest req, HttpServletResponse res) {
        return attendanceService.commutingRecords(req, res);
    }
    
    // 출퇴근 입력
    @RequestMapping(value = "/insertCommute")
    public String insertCommute(HttpServletRequest req, HttpServletResponse res) {
        attendanceService.insertCommute(req, res);
        
        return "hr/attendanceManagement";
    }
}
