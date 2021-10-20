package com.kosmo88.logistics_erp.account.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;
import com.kosmo88.logistics_erp.account.service.AccountRestService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value ="/account/rest")
public class AccountRestController {
	private static final Logger logger = LoggerFactory.getLogger(AccountRestController.class);
	
	@Autowired
	AccountRestService restService;
	
    // 장부관리 - 일반전표 상세내역 
    @RequestMapping(value="/slipInfo")
    public List<SlipDTO> detailInfo(HttpServletRequest request, HttpServletResponse response) {
    	logger.info("/slipInfo");
    	
    	return restService.slipDetailInfo(request, response);
    } 
    
    // 손익계산서 - 안드로이드
    @RequestMapping(value="/selectIncomeStatement")
    public IncomeStatementDTO incomeStatementSelect() {
    	logger.info("/selectIncomeStatement");
    	return restService.incomeStatementSelect(); 
    }
    
    // 재무상태표 - 안드로이드
    @RequestMapping(value="/selectFinancialStatement")
    public FinancialStatementsDTO financialStatementSelect() {
    	logger.info("/selectFinancialStatement");
    	return restService.financialStatementSelect(); 
    }
    
    //jsoup
    @RequestMapping(value = "/jsoup")
    public String jsoup(HttpServletRequest request, Model model) {
    	logger.info("/jsoup");
    	
    	final String inflearnUrl = "https://www.inflearn.com/courses/it-programming";
		Connection conn = Jsoup.connect(inflearnUrl);
		
		List<String> list = new ArrayList<String>();
		
		try {
			Document document = conn.get();
			 Elements img = document.getElementsByClass("swiper-lazy");
			 
			 for(Element pro : img) {
				 logger.info(pro.attr("abs:src"));
				 
				 list.add(pro.attr("abs:src"));
			 }
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
    	
    	return "account/temp/jsoup";
    }
    
}
