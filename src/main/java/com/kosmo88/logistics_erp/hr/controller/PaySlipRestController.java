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
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.service.PaySlipService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/hr/payslip")
public class PaySlipRestController {
    private static final Logger logger = LoggerFactory.getLogger(PaySlipRestController.class);

    @Autowired
    PaySlipService paySlipService;

    // 근태 조회
    @RequestMapping(value = "/paySlipList")
    public ArrayList<PaySlipDTO> selectAttendacne() {
        return paySlipService.totalPaySlip();
    }

}
