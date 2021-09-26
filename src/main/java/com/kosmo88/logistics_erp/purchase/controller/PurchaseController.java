package com.kosmo88.logistics_erp.purchase.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.purchase.service.PurchaseService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
    
    @Autowired
    PurchaseService purchaseService;
    
    // 거래처(구매처) 관리 - 거래처 목록
    @RequestMapping(value = "/clientManagement")
    public String clientManagement(HttpServletRequest req, Model model) {

    	purchaseService.clientList(req, model);
    	
        return "purchase/clientManagement";
    }

    // 거래처 등록 화면
    @RequestMapping(value = "/clientRegister")
    public String clientRegister(HttpServletRequest req, Model model) {
    	
    	purchaseService.clientList(req, model);
    	
    	return "purchase/clientRegister";
    }
    
    // 거래처 상품 등록 처리
    @RequestMapping(value = "/clientRegisterAction")
    public String clientRegisterAction(HttpServletRequest req, Model model) {
    	
    	purchaseService.RegisterClient(req, model);
    	
    	return "purchase/clientRegisterAction";
    }
    
    // 거래처 수정
    @RequestMapping(value = "/clientUpdate")
    public String clientUpdate(HttpServletRequest req, Model model) {
    	
    	// purchaseService.updateClient
    	
    	return "purchase/clientUpdate";
    }
    
    // 거래처 삭제(단일 삭제)
    @RequestMapping(value = "/clientDelete")
    public String clientDelete(HttpServletRequest req, Model model) {
    	
    	// purchaseService.updateClient
    	// (update)
    	
    	return "purchase/clientDelete";
    }    
    
    // 거래처 검색
    @RequestMapping(value = "/clientSearch")
    public String clientSearch(HttpServletRequest req, Model model) {
    	
    	// purchaseService.searchClient
    	
    	return "purchase/clientSearch";
    }
    
    // 거래처 삭제(선택삭제)
    @RequestMapping(value = "/clientChoiceDelete")
    public String clientChoiceDelete(HttpServletRequest req, Model model) {
    	
    	// service.deleteChoiceClient
    	// (update)
    	
    	return "purchase/clientChoiceDelete";
    }

    // 견적서 관리 - 목록
    @RequestMapping(value = "/estimateManagement")
    public String estimateManagement(HttpServletRequest req, Model model) {

    	// service.estimateList
    	
        return "purchase/estimateManagement";
    }
    
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

    // 견적서 검색
    @RequestMapping(value = "/estimateSearch")
    public String estimateSearch(HttpServletRequest req, Model model) {
    	
    	// service.searchEstimate
    	
    	return "purchase/estimateSearch";
    }
    
    // 견적서 등록
    @RequestMapping(value = "/estimateRegister") 
    public String estimateRegister(HttpServletRequest req, Model model) {
    	
    	// service.registerEstimate
    	
    	return "purchase/estimateRegister";
    }
    
    // 견적서 삭제(선택삭제)
    @RequestMapping(value = "/estimateChoiceDelete")
    public String estimateChoiceDelete(HttpServletRequest req, Model model) {
    	
    	// service.deleteChoiceEstimate
    	
    	return "purchase/estimateChoiceDelete";
    }
    
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

    // 발주서 검색
    @RequestMapping(value = "/purchaseSearch")
    public String purchaseSearch(HttpServletRequest req, Model model) {
    	
    	// service.searchPurchase
    	
    	return "purchase/purchaseSearch";
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
    
    // 구매전표 검색
    @RequestMapping(value = "/purchaseSlipSearch")
    public String purchaseSlipSearch(HttpServletRequest req, Model model) {
    	
    	// service.searchPurchaseSlip
    	
    	return "purchase/purchaseSlipSearch";
    } 
    
    // 구매전표 등록
    @RequestMapping(value = "/purchaseSlipRegister")
    public String purchaseSlipRegister(HttpServletRequest req, Model model) {
    	
    	// service.registerPurchaseSlip
    	
    	return "purchase/purchaseSlipRegister";
    }
    
}
