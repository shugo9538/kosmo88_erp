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
@RequestMapping(value = "/hr/holiday")
public class HolidayController {
    private static final Logger logger = LoggerFactory.getLogger(HolidayController.class);

    // 휴가 관리 메뉴
    @RequestMapping(value = "")
    public String leftHolidayNum(HttpServletRequest req, HttpServletResponse res) {
        return "hr/holidayManagement/holidayManagement";
    }
    
    // 휴가 사용실적
    @RequestMapping(value = "/useHolidayNum")
    public String useHolidayNum(HttpServletRequest req, HttpServletResponse res) {
//        holidayService.useHolidayNum(req, res);
        
        return "hr/holidayManagement";
    }
    
    // 근태 집계표
    @RequestMapping(value = "/attendanceTable")
    public String attendanceTable(HttpServletRequest req, HttpServletResponse res) {
//        holidayService.attendanceTable(req, res);
        
        return "hr/holidayManagement";
    }
}
