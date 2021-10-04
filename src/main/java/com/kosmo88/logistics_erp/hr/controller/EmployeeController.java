package com.kosmo88.logistics_erp.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // 근태 항목 관리
    @RequestMapping(value = "")
    public String attendanceCodeManagement(HttpServletRequest req, HttpServletResponse res) {
        return "hr/employeeManagement/employeeManagement";
    }
//    
//    // 근태 항목 추가
//    @RequestMapping(value = "/insertAttendanceCode")
//    public String insertAttendanceCode(HttpServletRequest req, HttpServletResponse res) {
//        configService.insertAttendanceCode(req, res);
//        
//        return "hr/configurations";
//    }
//    
//    // 사원별 휴가 일수 조회
//    @RequestMapping(value = "/employeeHasHoliday")
//    public String employeeHasHoliday(HttpServletRequest req, HttpServletResponse res) {
//        configService.employeeHasHoliday(req, res);
//        
//        return "hr/configurations";
//    }
}
