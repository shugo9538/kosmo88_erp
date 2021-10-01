package com.kosmo88.logistics_erp.sale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.sale.service.SalesClientService;
import com.kosmo88.logistics_erp.sale.service.SalesEstimateService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
//@RestController
@Controller
@RequestMapping(value = "/sales")
public class SalesEstimateController {

	@Autowired
    SalesEstimateService estimateService;
	
	
	// 거래처 검색
	@RequestMapping(value = "/selectClient")
	public String selectClient(HttpServletRequest req, Model model) {
		
		estimateService.clientList(req, model);
		
		return "sales/selectClient";
	}
	
	// 사원 검색
	@RequestMapping(value = "/selectEmployee")
	public String selectEmployee(HttpServletRequest req, Model model) {
		
		estimateService.employeeList(req, model);
		
		return "sales/selectEmployee";
	}
	
	// 견적서 관리 - 거래처 목록
	@RequestMapping(value="/estimateManagement")
	public String estimateManagement(HttpServletRequest req, Model model) {
		
		return "sales/estimateManagement";
	}
	
	// 견적서 등록 화면
	@RequestMapping(value = "/estimateRegister") 
	public String estimateRegister(HttpServletRequest req, Model model) {
		
		return "sales/estimateRegister";
	}
	
	
	
}
