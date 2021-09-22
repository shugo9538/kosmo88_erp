package com.kosmo88.logistics_erp.controller;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = "/sales")
public class SalesController {
    private static final Logger logger = LoggerFactory.getLogger(SalesController.class);

    // 거래처 등록
    @RequestMapping(value= "/clientResister")
    public String clientResister(HttpServletRequest request, Model model) {
    	logger.info("url => clientResister");
    	
    	
    	
    	return "sales/clientResister";
    }
    
    // 거래처 관리
    @RequestMapping(value = "/clientManagement")
    public String clientManagement(Model model) {

        return "sales/clientManagement";
    }

    // 판매 관리
    @RequestMapping(value = "/salesManagement")
    public String hrManagement(Model model) {

        return "sales/salesManagement";
    }

    // 견적서 관리
    @RequestMapping(value = "/estimateMangement")
    public String holidayManagement(Model model) {

        return "sales/estimateMangement";
    }

    // 주문서 관리
    @RequestMapping(value = "/orderManagement")
    public String requestManagement(Model model) {
        
        return "sales/orderManagement";
    }

    // 출하 관리
    @RequestMapping(value = "/shipmentManagement")
    public String slipManagement(Model model) {

        return "sales/shipmentManagement";
    }
}
