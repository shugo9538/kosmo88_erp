package com.kosmo88.logistics_erp.purchase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.purchase.service.ClientService;
import com.kosmo88.logistics_erp.purchase.service.EstimateService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/purchase")
public class EstimateController {
    private static final Logger logger = LoggerFactory.getLogger(EstimateController.class);
    
    @Autowired
    EstimateService estimateService;

    // 견적서 관리 - 목록
    @RequestMapping(value = "/estimateManagement")
    public String estimateManagement(HttpServletRequest req, Model model) {
    	
        return "purchase/estimateManagement";
    }
    
    // 견적서 등록 화면
    @RequestMapping(value = "/estimateRegister")
    public String estimateRegister(HttpServletRequest req, Model model) {
    	
    	return "purchase/estimateRegister";
    }
    
    // 견적서 등록 화면 - 견적서 거래처 선택
    @RequestMapping(value = "/selectClient")
    public String selectClient(HttpServletRequest req, Model model) {
    	
    	estimateService.selectClient(req, model);
    	
    	return "purchase/selectClient";
    }
    
    // 견적서 등록 화면 - 견적서 담당자 선택
    @RequestMapping(value = "/selectEmployee")
    public String selectEmployee(HttpServletRequest req, Model model) {
    	
    	estimateService.selectEmployee(req, model);
    	
    	return "purchase/selectEmployee";
    }
    
    // 견적서 상세페이지
    @RequestMapping(value = "/estimateDetail")
    public String estimateDetail(HttpServletRequest req, Model model) {

    	estimateService.estimateDetail(req, model);

    	return "purchase/estimateDetail";
    }
    
 	// 견적서 삭제(단일 삭제)
    @RequestMapping(value = "/estimateDelete")
    public String estimateDelete(HttpServletRequest req, Model model) {

    	estimateService.estimateDelete(req, model);
    	
        return "purchase/estimateDelete";
    }   
}
