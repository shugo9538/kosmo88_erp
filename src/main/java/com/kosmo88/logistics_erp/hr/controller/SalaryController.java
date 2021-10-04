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

import com.kosmo88.logistics_erp.hr.service.SalaryService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr/salary")
public class SalaryController {
    private static final Logger logger = LoggerFactory.getLogger(SalaryController.class);

    @Autowired
    SalaryService salaryService;

    // 월별 지급 및 현황
    @RequestMapping(value = "")
    public String leftHolidayNum(HttpServletRequest req, HttpServletResponse res) {
        return "hr/salaryManagement/salaryManagement";
    }
    
    // 휴가 사용실적
    @RequestMapping(value = "/useHolidayNum")
    public String useHolidayNum(HttpServletRequest req, HttpServletResponse res) {
//        salaryService.useHolidayNum(req, res);
        
        return "hr/holidayManagement";
    }
    
    // 근태 집계표
    @RequestMapping(value = "/attendanceTable")
    public String attendanceTable(HttpServletRequest req, HttpServletResponse res) {
//        salaryService.attendanceTable(req, res);
        
        return "hr/holidayManagement";
    }
}
