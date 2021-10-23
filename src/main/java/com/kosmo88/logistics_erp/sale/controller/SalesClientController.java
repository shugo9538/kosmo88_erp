package com.kosmo88.logistics_erp.sale.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.sale.service.SalesClientService;


//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
//@RestController
@Controller
@RequestMapping(value = "/sales")
public class SalesClientController {
	
	@Autowired
    SalesClientService clientService;
	
	// 거래처 목록
    @RequestMapping(value = "/clientManagement")
    public String clientManagement(HttpServletRequest req, Model model) {
    	
        return "sales/clientManagement";
    }
	
	// 거래처 등록 화면
	@RequestMapping(value = "/clientRegister") 
	public String clientRegister(HttpServletRequest req, Model model) {
	  
		return "sales/clientRegister"; 
	}
	 
	// 거래처 상세페이지
	@RequestMapping(value = "/clientDetail") 
	public String clientDetail(HttpServletRequest req, Model model) {
	  
		clientService.clientDetail(req, model);
		  
		return "sales/clientDetail"; 
	}
	
	// 거래처 수정페이지
	@RequestMapping(value = "/clientUpdate") 
	public String clientUpdate(HttpServletRequest req, Model model) {
	  
		clientService.clientUpdate(req, model);
		  
		return "sales/clientUpdate"; 
	}
	  
	// 거래처 수정 처리
	@RequestMapping(value = "/clientUpdateAction") 
	public String clientUpdateAction(HttpServletRequest req, Model model) {
	  
		clientService.clientUpdateAction(req, model);
		  
		return "sales/clientUpdateAction"; 
	}
	  
	// 거래처 삭제(상세페이지에서 단일 삭제)
	@RequestMapping(value = "/clientDelete") 
	public String clientDelete(HttpServletRequest req, Model model) {
	  
		clientService.clientDelete(req, model);
		  
		return "sales/clientDeleteAction"; 
	}
	
	
	 
}
