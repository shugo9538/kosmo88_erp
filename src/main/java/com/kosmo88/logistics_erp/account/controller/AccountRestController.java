package com.kosmo88.logistics_erp.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.account.service.AccountService;



//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value ="/accountInfo")
public class AccountRestController {
	private static final Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	
	@Autowired
	AccountService accountService;
	
	// 계좌등록시 계좌번호 중복체크
	@ResponseBody
	@RequestMapping(value="/account/confirm", method= {RequestMethod.GET, RequestMethod.POST})
	public int accountConfirm(String account_number) {
		System.out.println("account_number : " + account_number);
		return accountService.accountConfrim(account_number);
	}
	
	
	
}
