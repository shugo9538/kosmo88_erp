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

import com.kosmo88.logistics_erp.purchase.service.PurchaseService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
// @RestController
@Controller
@RequestMapping(value = "/purchase")
public class EstimateController {
    private static final Logger logger = LoggerFactory.getLogger(EstimateController.class);
    
    @Autowired
    PurchaseService purchaseService;

    // 견적서 관리 - 목록
    @RequestMapping(value = "/estimateManagement")
    public String estimateManagement(HttpServletRequest req, Model model) {
    	
        return "purchase/estimateManagement";
    }
/*    
    // 견적서 수정
    @RequestMapping(value = "/estimateUpdate")
    public String estimateUpdate(HttpServletRequest req, Model model) {

    	// service.updateEstimate
    	
        return "purchase/estimateUpdate";
    } 
    
    // 견적서 삭제(단일 삭제)
    @RequestMapping(value = "/estimateDelete")
    public String estimateDelete(HttpServletRequest req, Model model) {

    	// service.deleteEstimate
    	// (update)
    	
        return "purchase/estimateDelete";
    }     
    
    // 견적서 등록
    @RequestMapping(value = "/estimateRegister") 
    public String estimateRegister(HttpServletRequest req, Model model) {
    	
    	// service.registerEstimate
    	
    	return "purchase/estimateRegister";
    }
    
*/    
}
