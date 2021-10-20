package com.kosmo88.logistics_erp.purchase.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.purchase.service.ClientService;

@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/purchase")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    
    @Autowired
    ClientService clientService;
    
    // (구매처)상품 관리 - (구매처)상품 목록
    @RequestMapping(value = "/itemManagement")
    public String itemManagement(HttpServletRequest req, Model model) {
    	
    	return "purchase/itemManagement";
    }
    
    // 사업자번호 중복확인
    @RequestMapping(value = "/dupchkRegiNum")
    public String dupchkRegiNum(HttpServletRequest req, Model model) {
    	
    	clientService.dupchkRegiNum(req, model);
    	
    	return "purchase/dupchkRegiNum";
    }
    
    
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

    	clientService.clientDetail(req, model);

    	return "purchase/clientDetail";
    }
    
    // 거래처 수정페이지
    @RequestMapping(value = "/clientUpdate")
    public String clientUpdate(HttpServletRequest req, Model model) {
    	
    	clientService.clientUpdate(req, model);
    	
    	return "purchase/clientUpdate";
    }
    
    // 거래처 수정 처리
    @RequestMapping(value = "/clientUpdateAction")
    public String clientUpdateAction(HttpServletRequest req, Model model) {
    	
    	clientService.clientUpdateAction(req, model);
    	
    	return "purchase/clientUpdateAction";
    }
    
    // 거래처 삭제(상세페이지에서 단일 삭제)
    @RequestMapping(value = "/clientDelete")
    public String clientDelete(HttpServletRequest req, Model model) {
    	
    	clientService.clientDelete(req, model);
    	
    	return "purchase/clientDelete";
    }
}
