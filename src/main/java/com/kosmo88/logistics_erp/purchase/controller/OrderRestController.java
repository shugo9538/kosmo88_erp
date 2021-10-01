package com.kosmo88.logistics_erp.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;
import com.kosmo88.logistics_erp.purchase.service.OrderService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/purchase")
public class OrderRestController {
    private static final Logger logger = LoggerFactory.getLogger(OrderRestController.class);
    
    @Autowired
    OrderService orderService;
    
    // 구매 관리 - 발주서 목록
    @ResponseBody
    @RequestMapping(value = "/orderManagement/orderList")
    public List<PurchaseOrderListViewDTO> orderList(HttpServletRequest req, HttpServletResponse res) {
    	return orderService.orderList(req, res);
    }
/*    
    // 발주서 삭제(선택삭제)
    @ResponseBody
    @RequestMapping(value = "/orderManagement/orderChoiceDelete")
    public boolean orderChoiceDelete(@RequestBody String data) {
    	System.out.println(data);
    	data = data.replace("\"", "");
    	data = data.replace("request_id=", "");
    	String[] arrStr = data.split("&");
    	int[] request_id = new int[arrStr.length];
    	for(int i = 0; i < arrStr.length; i++) {
    		request_id[i] = Integer.parseInt(arrStr[i]);
    		System.out.println(request_id[i]);
    	}
    	return orderService.orderChoiceDelete(request_id);
    }
    
    // 등록한 발주서(구매) 목록
    @ResponseBody
    @RequestMapping(value = "/orderRegister/registeredOrderList")
    public List<PurchaseOrderDTO> registeredClientList(HttpServletRequest req, HttpServletResponse res) {
    	return orderService.orderList(req, res);
    }
    
    // 발주서 등록 처리
    @RequestMapping(value = "/orderRegister/orderRegisterAction")
    public boolean orderRegisterAction(@RequestBody PurchaseInsertOrderDTO dto) {
    	orderService.orderRegisterAction(dto);
    	return true;
    }
    
	// 상품 등록 처리
    @RequestMapping(value = "/orderRegister/itemRegisterAction")
    public boolean itemRegisterAction(@RequestBody List<OrderItemDTO> dtos) {
    	for (OrderItemDTO dto : dtos) {
    		orderService.itemRegisterAction(dto);
    	}
    	return true;
    }
*/    
}