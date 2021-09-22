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
@RequestMapping(value = "/logistics")
public class LogisticsController {
    private static final Logger logger = LoggerFactory.getLogger(LogisticsController.class);

    // 기초정보 환경 설정
    @RequestMapping(value = "/warehouseManagement")
    public String configurations(Model model) {

        return "logistics/warehouseManagement";
    }

    // 배차 관리
    @RequestMapping(value = "/dispatchingManagement")
    public String dispatchingManagement(Model model) {

        return "logistics/dispatchingManagement";
    }

    // 차량 관리
    @RequestMapping(value = "/carManagement")
    public String carManagement(Model model) {

        return "logistics/carManagement";
    }

    // 경로 정보
    @RequestMapping(value = "/routeInformation")
    public String routeInformation(Model model) {

        return "logistics/routeInformation";
    }

}