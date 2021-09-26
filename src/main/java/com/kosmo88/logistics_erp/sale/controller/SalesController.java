package com.kosmo88.logistics_erp.sale.controller;

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

    // 거래처 관리
    @RequestMapping(value= "/clientManagement")
    public String clientResister(HttpServletRequest request, Model model) {
    	logger.info("url => clientManagement");
    	
    	// service.resisterClient
    	
    	return "sales/clientManagement";
    }
    
    // 거래처 등록
    @RequestMapping(value="/clientRegister")
    public String clientRegister (HttpServletRequest request, Model model) {
    	logger.info("url => clientRegister");
    	
    	// service.resisterClient
    	
    	return "sales/clientRegister";
    }
    
    // 주문 관리
    @RequestMapping(value= "/orderManagement")
    public String orderManagement(HttpServletRequest request, Model model) {
    	logger.info("url => orderManagement");
    	
    	// service.resisterClient
    	
    	return "sales/orderManagement";
    }
    
    // 견적서 관리
    @RequestMapping(value="/estimateManagement")
    public String estimateManagement(HttpServletRequest request, Model model) {
    	logger.info("url => estimateManagement");
    	
    	
    	return "sales/estimateManagement";
    }
    
    
}
