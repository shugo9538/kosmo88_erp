package com.kosmo88.logistics_erp.sale.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.sale.service.SalesOrderService;

@SessionAttributes({"session", "userid"})
@Controller
@RequestMapping(value = "/sales")
public class SalesOrderController {

	@Autowired
	SalesOrderService orderService;
	
	// 주문서 목록
	@RequestMapping(value = "/orderManagement")
	public String orderManagement(HttpServletRequest req, Model model) {
		
		return "sales/orderManagement";
	}
	
	// 주문서 등록 화면
	@RequestMapping(value = "/orderRegister")
	public String orderRegister(HttpServletRequest res, Model model) {
		
		return "sales/orderRegister";
	}
	
	// 주문서 상세 페이지
	@RequestMapping(value = "/orderDetail")
	public String orderDetail(HttpServletRequest req, Model model) {
		
		orderService.orderDetail(req, model);
		
		return "sales/orderDetail";
	}
	
	// 주문서 삭제 페이지
	@RequestMapping(value = "/orderDelete")
	public String orderDelete(HttpServletRequest req, Model model) {
		
		System.out.println("삭제 전");
		orderService.orderDelete(req, model);
		System.out.println("삭제 후");
		
		return "sales/orderDelete";
	}
	
	// 견적서 불러오기
	@RequestMapping(value = "/selectEstimate")
	public String selectEstimate(HttpServletRequest req, Model model) {
		
		orderService.selectEstimate(req, model);
		
		return "sales/selectEstimate";
	}
	
}
