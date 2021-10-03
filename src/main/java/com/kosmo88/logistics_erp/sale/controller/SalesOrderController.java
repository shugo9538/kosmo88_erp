package com.kosmo88.logistics_erp.sale.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"session", "userid"})
@Controller
@RequestMapping(value = "/sales")
public class SalesOrderController {

	// 판매관리 - 주문서 목록
	@RequestMapping(value = "/orderManagement")
	public String orderManagement(HttpServletRequest req, Model model) {
		
		
		return "sales/orderManagement";
	}
	
	// 판매관리 - 주문서 등록
	@RequestMapping(value = "/orderRegister")
	public String orderRegister(HttpServletRequest res, Model model) {
		
		return "sales/orderRegister";
	}
	
}
