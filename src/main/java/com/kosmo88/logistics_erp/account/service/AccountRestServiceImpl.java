package com.kosmo88.logistics_erp.account.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kosmo88.logistics_erp.account.dao.AccountRestDAO;
import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

@Service
public class AccountRestServiceImpl implements AccountRestService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountRestServiceImpl.class);

	@Autowired
	AccountRestDAO accountRestDAO;
	
	@Override
	// 일반전표 세부내역 (승인시 확인)
	public List<SlipDTO> slipDetailInfo(HttpServletRequest request, HttpServletResponse response) {
		int slip_id = Integer.parseInt(request.getParameter("slip_id"));
		return (List<SlipDTO>) accountRestDAO.selectSlipInfo(slip_id);
	}

	// 손익계산서 목록조회
	@Override
	public IncomeStatementDTO incomeStatementSelect() {
		return accountRestDAO.selectIcomeStatement();
	}
	// 재무상태표 조회
	@Override
	public FinancialStatementsDTO financialStatementSelect() {
		return accountRestDAO.selectFinancialStatement();
	}
	
	
		
}	


	
	
	