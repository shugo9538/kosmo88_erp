package com.kosmo88.logistics_erp.hr.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RestController
@RequestMapping(value = "/hr/attendance")
public class AttendanceRestController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceRestController.class);

    @Autowired
    AttendanceService attendanceService;

    // 근태 조회
    @ResponseBody
    @RequestMapping(value = "/selectAttendacne")
    public ArrayList<AttendanceDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        return attendanceService.selectAttendacne(req, res);
    }

    // 근태 입력
    @RequestMapping(value = "/insertAttendanceAction")
    public boolean insertAttendanceAction(AttendanceDTO dto) {
        return attendanceService.insertAttendance(dto);
    }
    
    // 출퇴근 기록부
    @ResponseBody
    @RequestMapping(value = "/commuteList")
    public ArrayList<CommuteDTO> commuteList(HttpServletRequest req, HttpServletResponse res) {
        return attendanceService.commuteList(req, res);
    }
}
