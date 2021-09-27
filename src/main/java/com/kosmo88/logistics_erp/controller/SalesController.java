package com.kosmo88.logistics_erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.sale.service.SalesService;
import com.kosmo88.logistics_erp.sale.service.SalesServiceImpl;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/sales")
public class SalesController {
    private static final Logger logger = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    SalesService service;
    
    // 거래처 관리
    @RequestMapping(value= "/clientManagement")
    public String clientResister(HttpServletRequest request, Model model) {
    	logger.info("url => clientManagement");
    	
    	service.clientList(request, model);
    	
    	return "sales/clientManagement";
    }
    
    // 거래처 상세 정보
    @RequestMapping(value="/clientDetail")
    public String clientDetailList(HttpServletRequest request, Model model) {
    	
    	service.clientDetail(request, model);
    	
    	return "sales/clientDetail";
    }
    
    // 거래처 수정 페이지
    @RequestMapping(value="/clientUpdate")
    public String clientUpdate(HttpServletRequest request, Model model) {
    	
    	service.updateClient(request, model);
    	
    	return "sales/clientUpdate";
    }
    
    // 거래처 수정 처리 페이지
    @RequestMapping(value="/clientUpdateAction")
    public String clientUpdateAction(HttpServletRequest request, Model model) {
    	
    	service.updateClientAction(request, model);
    	
    	return "sales/clientUpdateAction";
    }
    
    
    // 거래처 삭제 페이지
    @RequestMapping(value="/clientDelete")
    public String clientDelete(HttpServletRequest request, Model model) {
    	
    	service.deleteClient(request, model);
    	
    	return "sales/clientDelete";
    }
    
    // 거래처 삭제 처리 페이지
    @RequestMapping(value="/clientDeleteAction")
    public String clientDeleteAction(HttpServletRequest request, Model model) {
    	
    	
    	
    	return "sales/clientDeleteAction";
    }
    
    // 거래처 등록
    @RequestMapping(value="/clientRegister")
    public String clientRegister (HttpServletRequest request, Model model) {
    	logger.info("url => clientRegister");
    	service.clientList(request, model);
    	return "sales/clientRegister";
    }
    
    // 거래처 등록 처리
    @RequestMapping(value="/clientRegisterAction")
    public String clientRegisterAction(HttpServletRequest request, Model model) {
    	
    	service.clientResister(request, model);
    	
    	return "sales/clientRegisterAction";
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
    
    // 출하 관리
    @RequestMapping(value="/shipmentManagement")
    public String shipmentManagement(HttpServletRequest request, Model model) {
    	logger.info("url => shipmentManagement");
    	
    	
    	return "sales/shipmentManagement";
    }
    
    
}
