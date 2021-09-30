package com.kosmo88.logistics_erp.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
public class EstimateRestController {
    private static final Logger logger = LoggerFactory.getLogger(EstimateRestController.class);
    
    @Autowired
    PurchaseService purchaseService;
/*    
    // 거래처(구매처) 목록
    @ResponseBody
    @RequestMapping(value = "/clientManagement/estimateList")
    public List<PurchaseClientDTO> estimateList(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.estimateList(req, res);
    }
*/    
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
