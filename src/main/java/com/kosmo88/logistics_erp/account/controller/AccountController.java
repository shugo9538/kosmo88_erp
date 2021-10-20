package com.kosmo88.logistics_erp.account.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.account.service.AccountService;
import com.kosmo88.logistics_erp.account.utilTest.FcmUtil;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	FcmUtil fcm;
	
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    //jsoup
    @RequestMapping(value = "/jsoup")
    public String jsoup(HttpServletRequest request, Model model) {
    	logger.info("/jsoup");
    	
    	service.jsoup(request, model);
    	
    	return "account/temp/jsoup";
    }
    //jsoup2
    @RequestMapping(value = "/jsoup2")
    public String jsoup2(HttpServletRequest request, Model model) {
    	logger.info("/jsoup2");
    	//1.Url 접근
    	final String naverNewsUrl = "https://news.naver.com/main/clusterArticles.naver?id=c_202109290810_00000125&mode=LSD&mid=shm&sid1=101&oid=366&aid=0000767182";
		Connection conn = Jsoup.connect(naverNewsUrl);
		
			try {
				Document document = conn.get();
				Elements element = document.getElementsByClass("nclicks(cls_eco.clsart1)");
				for (Element el : element) {
					System.out.println("el href: " + el.attr("abs:href"));
				}
				
				Elements ele = document.getElementsByClass("photo");
				for (Element el : ele) {
					System.out.println("el src: " + el.children().attr("abs:href"));
					System.out.println("el src: " + el.children().html());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
    	return "account/temp/jsoup2";
    }

    //------------------------ 기초정보관리 ------------------------
    // 기초정보관리 - 거래처 목록
    @RequestMapping(value = "/clientList")
    public String clientList(Model model) {
    	logger.info("/clientList");
    	
    	//service.accountingList(request, model);
    	service.clientList(model);
        return "account/clientList";
    }
    // 기초정보관리 - 거래처 등록 페이지
    @RequestMapping(value = "/clientDetail")
    public String clientDetail(HttpServletRequest request, Model model) {
    	logger.info("/clientDetail");
    	
    	
    	return "account/clientDetail";
    }
    // 기초정보관리 - 거래처 등록
    @RequestMapping(value = "/clientInsertAction")
    public String clientInsertAction(HttpServletRequest request, Model model) {
    	logger.info("/clientInsertAction");
    	
    	service.clientInsertAction(request, model);
    	return "account/clientInsertAction";
    }
    
    //------------------------ 장부관리/일반전표 ------------------------
    // 장부관리 - 일반전표 목록
    @RequestMapping(value="/slipList")
    public String slipList(Model model) {
    	logger.info("/slipList");
    	
    	//service.accountingList(request, model);
    	service.slipList(model);
    	return "account/slipList";
    }
    // 장부관리 - 일반전표 등록페이지
    @RequestMapping(value="/slipDetail")
    public String slipDetail(Model model) {
    	logger.info("/slipDetail");
    	
    	service.clientList(model);
    	
    	return "account/slipDetail";
    }
    // 장부관리 - 일반전표 지출결의 등록
    @RequestMapping(value="/slipInsertAction")
    public String slipDetailAction(HttpServletRequest request, Model model) {
    	logger.info("/slipDetailAction");
    	
    	service.slipInsertAction(request, model);
    	
    	return "account/slipInsertAction";
    }
    // 장부관리 - 일반전표 수정페이지
    @RequestMapping(value="/slipModifyDetail")
    public String slipModify(HttpServletRequest request, Model model) {
    	logger.info("/slipModifyDetail");
    	
    	service.slipModifyDetail(request, model);
    	
    	return "account/slipModify";
    }
    // 장부관리 - 부서별 일반전표 승인처리
    @RequestMapping(value="/slipConfirmAction")
    public String slipModifyAction(HttpServletRequest request, Model model) {
    	logger.info("/slipConfirmAction");
    	
    	service.slipConfirmAction(request, model);
    	
    	return "account/slipConfirmAction";
    }
    // 장부관리 - 부서별 일반전표 세부정보
    @RequestMapping(value="/slipDetailInfo")
    public String slipDetailInfo(HttpServletRequest request, Model model) {
    	logger.info("/slipDetailInfo");
    	
    	service.slipDetailInfo(request, model);
    	
    	return "account/slipDetailInfo";
    }
  //------------------------ 장부관리/매입/매출 전표 ------------------------
    // 장부관리 - 매입,매출전표 목록
    @RequestMapping(value = "/salesSlipList")
    public String salesList(HttpServletRequest request, Model model) {
    	logger.info("/salesSlipList");
    	
    	//service.accountingList(request, model);
    	service.salesSlipList(model);
        return "account/salesSlipList";
    }

    // 장부관리 - 매출전표 조회
    @RequestMapping(value = "/salesList")
    public String salesSlip(HttpServletRequest request, Model model) {
    	logger.info("/salesList");
    	service.salesList(model);
    	
        return "account/salesList";
    }
    
    // 장부관리 - 매입전표 조회
    @RequestMapping(value = "/purchaseList")
    public String purchase(HttpServletRequest request, Model model) {
    	logger.info("/purchaseList");
    	
    	service.purchaseList(model);
        return "account/purchaseList";
    }
    //------------------------ 금융/자금관리 ------------------------
    // 금융자금 - 통장목록 리스트
    @RequestMapping(value = "/accountList")
    public String accountList(HttpServletRequest req, Model model) {
    	logger.info("/accountList");
    	
    	service.accountList(req, model);
        
    	return "account/accountList";
    }
    // 금융자금 - 통장 입/출금 내역 상세페이지
    @RequestMapping(value = "/accountDetail")
    public String accountDetail(HttpServletRequest request, Model model) {
    	logger.info("/accountDetail");
    	
    	service.accountTransactionHistory(request, model);
    	
    	return "account/accountDetail";
    }
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
    //------------------------ 결산/재무제표------------------------
    // 결산/재무제표(재무상태표)
    @RequestMapping(value = "/financialStatement")
    public String financialStatement(Model model) {
    	logger.info("/financialStatement");
    	
    	service.financialStatementsSelect(model);
    	
        return "account/financialStatement";
    }
    // 재무제표(계정과목 상세페이지 - 매입매출전표)
    @RequestMapping(value = "/sales")
    public String sales(Model model) {
    	logger.info("/sales");
    	
    	service.salesSlipList(model);
    	
    	return "account/statement/salesList";
    }
    // 재무제표(계정과목 상세페이지)
    @RequestMapping(value = "/salesCost")
    public String salesCost(Model model) {
    	
    	service.salesList(model);
    	
    	return "account/statement/salesCost";
    }
//-------------------------- 손익 계산서 -------------------------    
    // 손익계산서
    @RequestMapping(value = "/incomeStatement")
    public String incomeStatement(Model model) {

    	service.incomeStatementSelect(model);
    	
        return "account/incomeStatement";
    }
//-------------------------- fcm -------------------------   
    // fcm
    @RequestMapping(value = "/fcm")
    public String fcmtest(HttpServletRequest request, HttpServletRequest reponse, Model model) throws Exception{
    	logger.debug("========================== fcm ddd ==========================");
    	
    	String tokenId = "d9ZLQRsbSWuNhewbzkBs7j:APA91bE4g3pc6rxsj9uuMkQ-Nl-5LNrdkJWplQvKzvAQhvCoPNme6FYKO9Yre2aFsc2aL2PGSA_0m5OAdpJCZGZT69angZNczVqauVorLKICm9rB2BWzqKHZ3_snAOaI4v7i0ub-9jPJ";
    	String title = "KU ERP Kosmo Ultimate ERP"; 
    	String content = "발주서 승인 되었습니다.";
    	
    	FcmUtil fcm = new FcmUtil();
    	fcm.send_FCM(tokenId, title, content);
    	
    	model.addAttribute("successCnt", 1);
    	
    	return "account/slipSendAction";
    }
    
}

