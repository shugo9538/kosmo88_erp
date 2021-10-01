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
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.service.EstimateService;
import com.kosmo88.logistics_erp.purchase.service.ClientService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/purchase")
public class EstimateRestController {
    private static final Logger logger = LoggerFactory.getLogger(EstimateRestController.class);
    
    @Autowired
    EstimateService estimateService;
    
    // 견적서 관리 - 견적서 목록(구매)
    @ResponseBody
    @RequestMapping(value = "/estimateManagement/estimateList")
    public List<PurchaseEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res) {
    	return estimateService.estimateList(req, res);
    }
    
    // 견적서 관리 - 견적서 삭제(선택삭제)
    @ResponseBody
    @RequestMapping(value = "/estimateManagement/estimateChoiceDelete")
    public boolean estimateChoiceDelete(@RequestBody String data) {
    	System.out.println(data);
    	data = data.replace("\"", "");
    	data = data.replace("request_id=", "");
    	String[] arrStr = data.split("&");
    	int[] request_id = new int[arrStr.length];
    	for(int i = 0; i < arrStr.length; i++) {
    		request_id[i] = Integer.parseInt(arrStr[i]);
    		System.out.println(request_id[i]);
    	}
    	return estimateService.estimateChoiceDelete(request_id);
    }
    
    
    /*   
    // 등록한 거래처(구매처) 목록
    @ResponseBody
    @RequestMapping(value = "/clientManagement/registeredClientList")
    public List<PurchaseClientDTO> registeredClientList(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.clientList(req, res);
    }


    // 거래처 수정
    @ResponseBody
    @RequestMapping(value = "/updateClient")
    public String updateClient(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.updateClient(req, res);
    }
	*/
    
}
