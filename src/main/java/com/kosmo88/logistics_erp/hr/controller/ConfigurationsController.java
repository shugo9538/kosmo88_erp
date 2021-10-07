package com.kosmo88.logistics_erp.hr.controller;

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

import com.kosmo88.logistics_erp.hr.service.ConfigurationService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/hr/configurations")
public class ConfigurationsController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationsController.class);

    @Autowired
    ConfigurationService configService;
    
    // 기초정보 환경설정 탭
    @RequestMapping(value = "")
    public String configurationsManagement(HttpServletRequest req, HttpServletResponse res) {
        return "hr/configurationManagement/configurationsManagement";
    }
    
    // 신규 인사 그룹 코드 등록
    @RequestMapping(value = "/insertHRGroupCode")
    public String insertHRGroupCode(HttpServletRequest req, HttpServletResponse res) {
        return "hr/configurationManagement/insertHRGroupCode";
    }
    
    // 신규 인사 코드 등록
    @RequestMapping(value = "/insertHRCode")
    public String insertHRCode(HttpServletRequest req, HttpServletResponse res) {
        return "hr/configurationManagement/insertHRCode";
    }
}
