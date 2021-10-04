package com.kosmo88.logistics_erp.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.account.service.AccountService;

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

    
    // 달력확인
    //jQuery
    @RequestMapping(value = "/jQuery")
    public String jQuery(HttpServletRequest request, Model model) {
    	logger.info("/jQuery");
        return "account/temp/jQuery";
    }
    //jQuery
    @RequestMapping(value = "/jQuery1")
    public String jQuery1(HttpServletRequest request, Model model) {
    	logger.info("/jQuery1");
        return "account/temp/jQuery1";
    }
    //jQuery
    @RequestMapping(value = "/jQuery2")
    public String jQuery2(HttpServletRequest request, Model model) {
    	logger.info("/jQuery2");
    	return "account/temp/jQuery2";
    }
    //jQuery
    @RequestMapping(value = "/sweetalert")
    public String sweetalert(HttpServletRequest request, Model model) {
    	logger.info("/sweetalert");
    	return "account/temp/sweetalert";
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
    // 장부관리 - 일반전표 수정페이지
    @RequestMapping(value="/slipModifyDetail")
    public String slipModify(HttpServletRequest request, Model model) {
    	logger.info("/slipModifyDetail");
    	
    	service.slipModifyDetail(request, model);
    	
    	return "account/slipModify";
    }
<<<<<<< HEAD:src/main/java/com/kosmo88/logistics_erp/member/controller/AccountController.java
    
=======
    // 장부관리 - 부서별 일반전표 승인처리
    @RequestMapping(value="/slipConfirmAction")
    public String slipModifyAction(HttpServletRequest request, Model model) {
    	logger.info("/slipConfirmAction");
    	
    	service.slipConfirmAction(request, model);
    	
    	return "account/slipConfirmAction";
    }
    
  //------------------------ 장부관리/매입/매출 전표 ------------------------
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0:src/main/java/com/kosmo88/logistics_erp/account/controller/AccountController.java
    // 장부관리 - 매입,매출전표 목록
    @RequestMapping(value = "/salesSlipList")
    public String salesList(HttpServletRequest request, Model model) {
    	logger.info("/salesSlipList");
    	
    	service.accountingList(request, model);
    	
        return "account/salesSlipList";
    }

    // 장부관리 - 매입/매출장(매출전표목록)
    @RequestMapping(value = "/salesList")
    public String salesSlip(HttpServletRequest request, Model model) {
    	
    	//service.accountingList(request, model);
    	
        return "account/salesList";
    }
    
    // 장부관리 - 매입/매출장(매입전표목록)
    @RequestMapping(value = "/purchaseList")
    public String purchase(HttpServletRequest request, Model model) {
    	logger.info("/purchaseList");
    	
    	//service.accountingList(request, model);
    	
        return "account/purchaseList";
    }
    
    //------------------------ 금융/자금관리 ------------------------
    // 금융자금 - 통장목록 리스트
    @RequestMapping(value = "/accountList")
    public String accountList(HttpServletRequest request, Model model) {
    	logger.info("/accountList");
    	
    	service.accountingList(request, model);
    	
        return "account/accountList";
    }
    // 금융자금 - 통장 입/출금 내역 상세페이지
    @RequestMapping(value = "/accountDetail")
    public String accountDetail(HttpServletRequest request, Model model) {
    	logger.info("/accountDetail");
    	
    	service.accountTransactionHistory(request, model);
    	
    	return "account/accountDetail";
    }
    /*
    // 금융자금 - 통장 입/출금 내역 상세페이지 잔액
    @RequestMapping(value = "/accountBalance")
    public String accountBalance(HttpServletRequest request, Model model) {
    	logger.info("/accountBalance");
    	
    	service.accountBalance(request, model);
    	
    	return "account/accountDetail";
    }
    */
    // 금융자금 - 신규통장 추가 페이지
    @RequestMapping(value = "/accountNewDetail")
    public String newAccount(HttpServletRequest request, Model model) {
    	logger.info("/accountNewDetail");
    	
    	return "account/accountNewDetail";
    }
    // 금융자금 - 신규통장 추가시 계좌번호 중복확인
    @RequestMapping(value = "/accountNumberCheck")
    public String accountNumberCheck(HttpServletRequest request, Model model) {
    	logger.info("/accountNumberCheck");
    	
    	service.accountNumberCheck(request, model);
    	
    	return "account/accountNumberCheck";
    }
    // 금융자금 - 신규통장 추가 처리
    @RequestMapping(value = "/accountInsertAction")
    public String newAccountAction(HttpServletRequest request, Model model) {
    	logger.info("/accountInsertAction");
    	
    	service.accountInsertAction(request, model);
    	
    	return "account/accountInsertAction";
    }
    // 금융자금 - 미사용 통장 조회
    @RequestMapping(value = "/accountEnabledDetail")
    public String accountModifyDetail(HttpServletRequest request, Model model) {
    	logger.info("/accountModifyDetail");
    	
    	service.accountEnabledDetail(request, model);
    	
    	return "account/accountEnabledDetail";
    }
    // 금융자금 - 등록통장 미사용 처리
    @RequestMapping(value = "/accountEnabledAction")
    public String accountModifyAction(HttpServletRequest request, Model model) {
    	logger.info("/accountModifyAction");
    	
    	service.accountEnabledAction(request, model);
    	
    	return "account/accountEnabledAction";
    }
    
    // 금융자금 - 통장 거래내역 단건추가 페이지
    @RequestMapping(value = "/accountSimplDetail")
    public String accountSimplDetail(HttpServletRequest request, Model model) {
    	logger.info("/accountSimplDetail");
    	
    	service.accountSimplDetail(request, model);
    	
    	return "account/accountSimplDetail";
    }
    // 금융자금 - 통장 거래내역 단건 추가처리
    @RequestMapping(value = "/accountSimplAction")
    public String accountSimplDetailAction(HttpServletRequest request, Model model) {
    	logger.info("/accountSimplAction");
    	
    	service.accountSimplAction(request, model);
    	
    	return "account/accountSimplAction";
    }
    // 금융자금 - 통장 거래내역 추가(다건)
    @RequestMapping(value = "/accountMultitDetail")
    public String accountMultitDetail(HttpServletRequest request, Model model) {
    	logger.info("/accountMultitDetail");
    	
    	
    	return "account/accountMultitDetail";
    }
    
    //------------------------ 결산/재무제표------------------------
    // 결산/재무제표(재무상태표)
    @RequestMapping(value = "/financialStatement")
    public String financialStatement(Model model) {

    	service.financialStatementsSelect(model);
    	
        return "account/financialStatement";
    }
    // 재무제표(계정과목 상세페이지)
    @RequestMapping(value = "/accountTitleDetail")
    public String accountTitleDetail(Model model) {
    	
    	return "account/accountTitleDetail";
    }
    
    // 손익계산서
    @RequestMapping(value = "/incomeStatement")
    public String incomeStatement(Model model) {

    	service.incomeStatementSelect(model);
    	
        return "account/incomeStatement";
    }
}
