package com.kosmo88.logistics_erp.purchase.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.purchase.service.OrderService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/purchase")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    
    @Autowired
    OrderService orderService;
    
    // 발주서 관리 - 발주서 목록
    @RequestMapping(value = "/orderManagement")
    public String orderManagement(HttpServletRequest req, Model model) {
    	
        return "purchase/orderManagement";
    }

    // 발주서 등록 화면
    @RequestMapping(value = "/orderRegister")
    public String orderRegister(HttpServletRequest req, Model model) {
    	
    	return "purchase/orderRegister";
    }
    
    // 발주서 상세페이지
    @RequestMapping(value = "/orderDetail")
    public String orderDetail(HttpServletRequest req, Model model) {

    	orderService.orderDetail(req, model);

    	return "purchase/orderDetail";
    }
    
    // 발주서 삭제(상세페이지에서 단일 삭제)
    @RequestMapping(value = "/orderDelete")
    public String orderDelete(HttpServletRequest req, Model model) {
    	
    	orderService.orderDelete(req, model);
    	
    	return "purchase/orderDelete";
    }
   
}
