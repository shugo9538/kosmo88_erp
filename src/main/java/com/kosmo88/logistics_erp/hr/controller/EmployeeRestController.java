package com.kosmo88.logistics_erp.hr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.service.EmployeeService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/hr/employee")
public class EmployeeRestController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    EmployeeService employeeService;

    // 인사카드 목록 조회
    @RequestMapping(value = "/selectEmployee")
    public ArrayList<EmployeeDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        return employeeService.employeeManagement();
    }

//    // 근태 입력
//    @RequestMapping(value = "/insertAttendanceAction")
//    public boolean insertAttendanceAction(@RequestBody List<AttendanceDTO> dto) {
//        for (AttendanceDTO d : dto) {
//            employeeService.insertAttendance(d);
//        }
//        return true;
//    }
//    
//    // 출퇴근 기록부
//    @RequestMapping(value = "/commuteList")
//    public ArrayList<CommuteDTO> commuteList(HttpServletRequest req, HttpServletResponse res) {
//        return employeeService.commuteList(req, res);
//    }
//    
//    // 출퇴근 입력
//    @RequestMapping(value = "/insertCommuteAction")
//    public boolean insertCommuteAction(@RequestBody List<CommuteDTO> dto) {
//        System.out.println(dto.get(0).getEmployee_id());
//        for (CommuteDTO d : dto) {
//            employeeService.insertCommute(d);
//        }
//        
//        return true;
//    }
}