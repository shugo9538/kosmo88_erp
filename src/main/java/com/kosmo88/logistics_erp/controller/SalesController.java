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
    @RequestMapping(value= "/clientManagement")
    public String clientResister(HttpServletRequest request, Model model) {
    	logger.info("url => clientManagement");
    	
    	// service.resisterClient
    	
    	return "sales/clientManagement";
    }
    
    // 거래처 목록
    @RequestMapping(value="/clientList")
    public String clientList(HttpServletRequest request, Model model) {
    	
    	// service.clientList(HttpServletRequest request, Model model)
    	
    	return "sale/clientList";
    }
    
    // 거래처 수정
    
    
    // 견적서 등록
    @RequestMapping(value="estimateResister")
    public String estimateResister(HttpServletRequest request, Model model) {
    	
    	return "sale/estimateResister";
    }
    
    // 견적서 목록
    @RequestMapping(value="estimateList")
    public String estimateList(HttpServletRequest request, Model model) {
    	
    	return "sale/estimateList";
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
