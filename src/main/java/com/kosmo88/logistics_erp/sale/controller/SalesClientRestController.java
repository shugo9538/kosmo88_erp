package com.kosmo88.logistics_erp.sale.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertClientDTO;
import com.kosmo88.logistics_erp.sale.service.SalesClientService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/sales")
public class SalesClientRestController {
	private static final Logger logger = LoggerFactory.getLogger(SalesClientRestController.class);
	
	@Autowired
	SalesClientService clientService;
	
	// 거래처 목록
    @ResponseBody
    @RequestMapping(value = "/clientManagement/clientList", produces = "application/json; charset=UTF-8")
    public List<SalesClientDTO> clientList(HttpServletRequest req, HttpServletResponse res) {
    	logger.info("current => clientJson");
    	return clientService.clientList(req, res);
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
    	for(int i = 0; i < arrStr.length; i++) {
    		client_id[i] = Integer.parseInt(arrStr[i]);
    		System.out.println(client_id[i]);
    	}
    	return clientService.clientChoiceDelete(client_id);
    }
    
    // 등록한 거래처 목록
    @ResponseBody
    @RequestMapping(value = "/clientRegister/registeredClientList")
    public List<SalesClientDTO> registeredClientList(HttpServletRequest req, HttpServletResponse res) {
    	return clientService.clientList(req, res);
    }
    
    // 거래처 등록 처리
    @RequestMapping(value = "/clientRegister/clientRegisterAction")
    public boolean clientRegisterAction(@RequestBody SalesInsertClientDTO dto) {
    	clientService.clientRegisterAction(dto);
    	return true;
    }
}
