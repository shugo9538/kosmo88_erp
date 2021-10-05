package com.kosmo88.logistics_erp.hr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
    public ArrayList<EmployeeDTO> selectEmployee(HttpServletRequest req, HttpServletResponse res) {
        return employeeService.employeeManagement();
    }

    // 인사카드 상세
    @RequestMapping(value = "/{id}")
    public ModelAndView detailEmployee(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("hr/employeeManagement/detailEmployee");
        employeeService.detailEmployee(mav, id);
        return mav;
    }
    
    // 인사카드 수정
    @RequestMapping(value = "/{id}/updatesEmployee")
    public ModelAndView updatesEmployee(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("hr/employeeManagement/updatesEmployee");
        employeeService.updateEmployee(mav, id);
        return mav;
    }
}
