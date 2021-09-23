package com.kosmo88.logistics_erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr")
public class HRController {
    private static final Logger logger = LoggerFactory.getLogger(HRController.class);

    // 기초정보 환경 설정
    @RequestMapping(value = "/configurations")
    public String configurations(Model model) {

        return "hr/configurations";
    }

    // 인사카드관리
    @RequestMapping(value = "/hrManagement")
    public String hrManagement(Model model) {

        return "hr/hrManagement";
    }

    // 근태 관리
    @RequestMapping(value = "/attendanceManagement")
    public String attendanceManagement(Model model) {

        return "hr/attendanceManagement";
    }

    // 휴가 관리
    @RequestMapping(value = "/holidayManagement")
    public String holidayManagement(Model model) {

        return "hr/holidayManagement";
    }

    // 급여 관리
    @RequestMapping(value = "/salaryManagement")
    public String salaryManagement(Model model) {

        return "hr/salaryManagement";
    }

    // 전표 관리
    @RequestMapping(value = "/slipManagement")
    public String slipManagement(Model model) {

        return "hr/slipManagement";
    }
}
