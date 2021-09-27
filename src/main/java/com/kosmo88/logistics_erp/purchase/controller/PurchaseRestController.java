package com.kosmo88.logistics_erp.purchase.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.service.PurchaseService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
// @RestController
// @RequestMapping(value = "/purchase")
public class PurchaseRestController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseRestController.class);
    
    @Autowired
    PurchaseService purchaseService;
    
    // 거래처(구매처) 관리
/*    
    @ResponseBody
    @RequestMapping(value = "/clientList")
    public ArrayList<PurchaseClientDTO> clientManagement(HttpServletRequest req, HttpServletResponse res) {
    	return purchaseService.clientList(req, res);
    }
*/   
    
}
