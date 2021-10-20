package com.kosmo88.logistics_erp.account.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

public interface AccountRestService {
	
	// 일반전표 세부내역
	public List<SlipDTO> slipDetailInfo(HttpServletRequest request, HttpServletResponse response);
	
	// 손익계산서 조회
	public IncomeStatementDTO incomeStatementSelect();
	
	// 재무상태표 조회
	public FinancialStatementsDTO financialStatementSelect();

}
