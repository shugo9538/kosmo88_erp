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

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;
import com.kosmo88.logistics_erp.hr.service.ConfigurationService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/hr/configurations")
public class ConfigurationsRestController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationsRestController.class);

    @Autowired
    ConfigurationService configService;

    // 인사 코드 조회
    @RequestMapping(value = "/selectHRCode")
    public ArrayList<HRCodeDTO> selectHRCode(HttpServletRequest req, HttpServletResponse res) {
        return configService.selectHRCode();
    }

    // 부서 코드 관리
    @RequestMapping(value = "/selectDepartments")
    public ArrayList<DepartmentCodeDTO> selectDepartments(HttpServletRequest req, HttpServletResponse res) {
        return configService.selectDepartments();
    }

    // 직급 코드 관리
    @RequestMapping(value = "/selectPosition")
    public ArrayList<PositionCodeDTO> selectPosition(HttpServletRequest req, HttpServletResponse res) {
        return configService.selectPosition();
    }

    // 근태 코드 관리
    @RequestMapping(value = "/selectAttendanceCode")
    public ArrayList<AttendanceCodeDTO> selectAttendanceCode(HttpServletRequest req, HttpServletResponse res) {
        return configService.selectAttendanceCode();
    }

    // 인사코드 입력
    @RequestMapping(value = "/insertHrCodeAction")
    public boolean insertAttendanceAction(@RequestBody List<HRCodeDTO> dto) {
        for (HRCodeDTO d : dto) {
            configService.insertHRCode(d);
        }
        return true;
    }
//    
//    // 출퇴근 기록부
//    @RequestMapping(value = "/commuteList")
//    public ArrayList<CommuteDTO> commuteList(HttpServletRequest req, HttpServletResponse res) {
//        return configService.commuteList(req, res);
//    }
//    
//    // 출퇴근 입력
//    @RequestMapping(value = "/insertCommuteAction")
//    public boolean insertCommuteAction(@RequestBody List<CommuteDTO> dto) {
//        System.out.println(dto.get(0).getEmployee_id());
//        for (CommuteDTO d : dto) {
//            configService.insertCommute(d);
//        }
//        
//        return true;
//    }
}
