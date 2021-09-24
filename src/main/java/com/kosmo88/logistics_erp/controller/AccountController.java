package com.kosmo88.logistics_erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.account.service.AccountService;
import com.kosmo88.logistics_erp.account.service.AccountServiceImpl;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    // 기초정보 관리
    @RequestMapping(value = "/configurations")
    public String configurations(Model model) {

        return "account/configurations";
    }

    // 전표입력/장부관리
    @RequestMapping(value = "/statementBook")
    public String hrManagement(Model model) {

        return "account/statementBook";
    }

    // 금융/자금관리
    @RequestMapping(value = "/financialFunds")
    public String attendanceManagement(Model model) {
    	
        return "account/financialFunds";
    }

    
    //------------------------ 기초정보관리 ------------------------
    //
    // 기초정보관리 - 거래처 목록
    @RequestMapping(value = "/clientList")
    public String clientList(HttpServletRequest request, Model model) {
    	logger.info("/clientList");
    	
    	service.accountingList(request, model);

        return "account/clientList";
    }
    
    //------------------------ 장부관리 ------------------------
    // 장부관리 - 일반전표 목록
    @RequestMapping(value="/slipList")
    public String slipList(HttpServletRequest request, Model model) {
    	logger.info("/slipList");
    	
    	service.accountingList(request, model);
    	
    	return "account/slipList";
    }
    // 장부관리 - 일반전표 등록페이지
    @RequestMapping(value="/slipDetail")
    public String slipDetail(HttpServletRequest request, Model model) {
    	logger.info("/slipDetail");
    	
    	
    	return "account/slipDetail";
    }
    // 장부관리 - 일반전표 등록페이지
    @RequestMapping(value="/slipModify")
    public String slipModify(HttpServletRequest request, Model model) {
    	logger.info("/slipModify");
    	
    	
    	return "account/slipModify";
    }
    
    // 장부관리 - 매입/매출장 목록
    @RequestMapping(value = "/salesSlipList")
    public String salesList(HttpServletRequest request, Model model) {
    	logger.info("/salesSlipList");
    	
    	service.accountingList(request, model);
    	
        return "account/salesSlipList";
    }
    
    // 장부관리 - 매입/매출장(매출전표목록)
    @RequestMapping(value = "/salesList")
    public String salesSlip(HttpServletRequest request, Model model) {
    	
        return "account/salesList";
    }
    
    // 장부관리 - 매입/매출장(매입전표목록)
    @RequestMapping(value = "/purchaseList")
    public String purchase(HttpServletRequest request, Model model) {

        return "account/purchaseList";
    }
    
    //------------------------ 금융/자금관리 ------------------------
    // 금융자금 - 통장거래내역
    @RequestMapping(value = "/accountList")
    public String accountList(HttpServletRequest request, Model model) {
    	logger.info("/accountList");
    	
    	service.accountingList(request, model);
    	
        return "account/accountList";
    }
    
    //------------------------ 결산/재무제표------------------------
    // 결산/재무제표(재무상태표)
    @RequestMapping(value = "/financialStatement")
    public String financialStatement(HttpServletRequest request, Model model) {

        return "account/financialStatement";
    }
    
    // 손익계산서
    @RequestMapping(value = "/incomeStatement")
    public String incomeStatement(HttpServletRequest request, Model model) {

        return "account/incomeStatement";
    }
}
