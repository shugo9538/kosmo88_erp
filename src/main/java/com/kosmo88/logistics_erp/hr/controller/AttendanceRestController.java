package com.kosmo88.logistics_erp.hr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.service.AttendanceService;

@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/hr/attendance")
public class AttendanceRestController {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceRestController.class);

    @Autowired
    AttendanceService attendanceService;

    // 근태 조회
    @RequestMapping(value = "/selectAttendacne")
    public ArrayList<AttendanceDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        return attendanceService.selectAttendacne();
    }

    // 근태 입력
    @RequestMapping(value = "/insertAttendanceAction")
    public boolean insertAttendanceAction(@RequestBody List<AttendanceDTO> dto) {
        for (AttendanceDTO d : dto) {
            attendanceService.insertAttendance(d);
        }
        return true;
    }
    
    // 출퇴근 기록부
    @RequestMapping(value = "/commuteList")
    public ArrayList<CommuteDTO> commuteList(HttpServletRequest req, HttpServletResponse res) {
        return attendanceService.commuteList(req, res);
    }
    
    // 출퇴근 입력
    @RequestMapping(value = "/insertCommuteAction")
    public boolean insertCommuteAction(@RequestBody List<CommuteDTO> dto) {
        for (CommuteDTO d : dto) {
            attendanceService.insertCommute(d);
        }
        
        return true;
    }
}
