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
public class PurchaseController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
    
    @Autowired
    PurchaseService purchaseService;
    
    // 거래처(구매처) 관리 - 거래처 목록
    @RequestMapping(value = "/clientManagement")
    public String clientManagement(HttpServletRequest req, Model model) {
    	
        return "purchase/clientManagement";
    }

    // 거래처 등록 화면
    @RequestMapping(value = "/clientRegister")
    public String clientRegister(HttpServletRequest req, Model model) {
    	
    	return "purchase/clientRegister";
    }
    
    // 거래처 상세페이지
    @RequestMapping(value = "/clientDetail")
    public String clientDetail(HttpServletRequest req, Model model) {

    	purchaseService.clientDetail(req, model);

    	return "purchase/clientDetail";
    }
    
    // 거래처 수정페이지
    @RequestMapping(value = "/clientUpdate")
    public String clientUpdate(HttpServletRequest req, Model model) {
    	
    	purchaseService.clientUpdate(req, model);
    	
    	return "purchase/clientUpdate";
    }
    
    // 거래처 수정 처리
    @RequestMapping(value = "/clientUpdateAction")
    public String clientUpdateAction(HttpServletRequest req, Model model) {
    	
    	purchaseService.clientUpdateAction(req, model);
    	
    	return "purchase/clientUpdateAction";
    }
    
    // 거래처 삭제(상세페이지에서 단일 삭제)
    @RequestMapping(value = "/clientDelete")
    public String clientDelete(HttpServletRequest req, Model model) {
    	
    	purchaseService.clientDelete(req, model);
    	
    	return "purchase/clientDeleteAction";
    }
    

/*  
    
    // 구매 관리(발주) - 발주서 목록
    @RequestMapping(value = "/purchaseManagement")
    public String purchaseManagement(HttpServletRequest req, Model model) {

    	// service.purchaseList
    	
        return "purchase/purchaseManagement";
    }
    
    // 발주서 수정
    @RequestMapping(value = "/purchaseUpdate")
    public String purchaseUpdate(HttpServletRequest req, Model model) {
    	
    	// service.updatePurchase
    	
    	return "purchase/purchaseUpdate";
    }
    
    // 발주서 삭제(단일 삭제)
    @RequestMapping(value = "/purchaseDelete")
    public String purchaseDelete(HttpServletRequest req, Model model) {
    	
    	// service.deletePurchase
    	// (update)
    	
    	return "purchase/purchaseDelete";
    }
    
    // 발주서 등록
    @RequestMapping(value = "/purchaseRegister")
    public String purchaseRegister(HttpServletRequest req, Model model) {
    	
    	// service.registerPurchase
    	
    	return "purchase/purchaseRegister";
    }
    
    // 발주서 삭제(선택삭제)
    @RequestMapping(value = "/purchaseChoiceDelete")
    public String purchaseChoiceDelete(HttpServletRequest req, Model model) {
    	
    	// service.deleteChoicePurchase
    	// (update)
    	
    	return "purchase/purchaseChoiceDelete";
    }
    
    // 구매전표 관리 - 목록
    @RequestMapping(value = "/purchaseSlipManagement")
    public String purchaseSlipManagement(HttpServletRequest req, Model model) {
    	
    	// service.purchaseSlipList
    	
    	return "purchase/purchaseSlipManagement";
    }
    
    // 구매전표 수정
    @RequestMapping(value = "/purchaseSlipUpdate")
    public String purchaseSlipUpdate(HttpServletRequest req, Model model) {
    	
    	// service.updatePurchaseSlip
    	
    	return "purchase/purchaseSlipUpdate";
    }
    
    // 구매전표 삭제
    @RequestMapping(value = "/purchaseSlipDelete")
    public String purchaseSlipDelete(HttpServletRequest req, Model model) {
    	
    	// service.deletePurchaseSlip
    	
    	return "purchase/purchaseSlipDelete";
    }
    
    // 구매전표 등록
    @RequestMapping(value = "/purchaseSlipRegister")
    public String purchaseSlipRegister(HttpServletRequest req, Model model) {
    	
    	// service.registerPurchaseSlip
    	
    	return "purchase/purchaseSlipRegister";
    }
*/    
}
