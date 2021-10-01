package com.kosmo88.logistics_erp.hr.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.service.HolidayService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/hr/holiday")
public class HolidayRestController {
    private static final Logger logger = LoggerFactory.getLogger(HolidayRestController.class);

    @Autowired
    HolidayService holidayService;

    // 휴가 잔여일수 조회
    @RequestMapping(value = "/selectHoliday")
    public ArrayList<HolidayUsageStatusDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        return holidayService.leftHolidayNum();
    }
    
}
