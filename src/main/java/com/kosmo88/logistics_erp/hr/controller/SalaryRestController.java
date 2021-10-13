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

import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;
import com.kosmo88.logistics_erp.hr.service.SalaryService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/hr/salary")
public class SalaryRestController {
    private static final Logger logger = LoggerFactory.getLogger(SalaryRestController.class);

    @Autowired
    SalaryService salaryService;

    // 근태 조회
    @RequestMapping(value = "/salaryList")
    public ArrayList<SalaryDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        return salaryService.monthlyPaymentAndStatus();
    }

    // 급여 입력
    @RequestMapping(value = "/insertSalaryAction")
    public boolean insertSalaryAction(@RequestBody List<SalaryDTO> dto) {
        boolean result = true;
        for (SalaryDTO d : dto) {
            if (!salaryService.insertSalaryAction(d)) result = false;
        }
        return result;
    }
}
