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
import com.kosmo88.logistics_erp.purchase.service.PurchaseService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/purchase")
public class PurchaseRestController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseRestController.class);
    
    @Autowired
    PurchaseService purchaseService;
    
    // 거래처(구매처) 목록
    @ResponseBody
    @RequestMapping(value = "/clientManagement/clientList")
    public List<PurchaseClientDTO> clientList(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.clientList(req, res);
    }
    
    // 거래처 삭제(선택삭제)
    @ResponseBody
    @RequestMapping(value = "/clientManagement/clientChoiceDelete")
    public boolean clientChoiceDelete(@RequestBody String data) {
    	System.out.println(data);
    	data = data.replace("\"", "");
    	data = data.replace("client_id=", "");
    	String[] arrStr = data.split("&");
    	int[] client_id = new int[arrStr.length];
    	for(int i = 0; i < arrStr.length ; i++) {
    		client_id[i] = Integer.parseInt(arrStr[i]);
    		System.out.println(client_id[i]);
    	}
    	return purchaseService.clientChoiceDelete(client_id);
    }
    
    // 등록한 거래처(구매처) 목록
    @ResponseBody
    @RequestMapping(value = "/clientRegister/registeredClientList")
    public List<PurchaseClientDTO> registeredClientList(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.clientList(req, res);
    }
    
    // 거래처, 상품 등록 처리
    @ResponseBody
    @RequestMapping(value = "/clientRegister/clientRegisterAction")
    public boolean clientRegisterAction(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.clientRegisterAction(req, res);
    }


}
