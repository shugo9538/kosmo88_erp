package com.kosmo88.logistics_erp.hr.controller;

import java.util.List;

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

import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.service.HRService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr/holiday")
public class HolidayController {
    private static final Logger logger = LoggerFactory.getLogger(HolidayController.class);

    @Autowired
    HRService hrService;

    // 휴가 잔여일수 현황
    @RequestMapping(value = "/leftHolidayNum")
    public String leftHolidayNum(HttpServletRequest req, HttpServletResponse res) {
        hrService.leftHolidayNum(req, res);
        
        return "hr/holidayManagement";
    }
    
    // 휴가 사용실적
    @RequestMapping(value = "/useHolidayNum")
    public String useHolidayNum(HttpServletRequest req, HttpServletResponse res) {
        hrService.useHolidayNum(req, res);
        
        return "hr/holidayManagement";
    }
    
    // 근태 집계표
    @RequestMapping(value = "/attendanceTable")
    public String attendanceTable(HttpServletRequest req, HttpServletResponse res) {
        hrService.attendanceTable(req, res);
        
        return "hr/holidayManagement";
    }
}
