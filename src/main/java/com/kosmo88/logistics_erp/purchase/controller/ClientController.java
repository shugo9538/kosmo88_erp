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

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/purchase")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    
    @Autowired
    ClientService clientService;
    
    // 거래처(구매처) 관리 - 거래처 목록S
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
