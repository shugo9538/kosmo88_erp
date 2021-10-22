package com.kosmo88.logistics_erp.account.dao;

import java.util.List;

import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

public interface AccountRestDAO {
	
	// 일반전표 - 일반전표 세부내역
	public List<SlipDTO> selectSlipInfo(int slip_id);
	
	// 손익계산서 조회
	public IncomeStatementDTO selectIcomeStatement();
	
	// 거래처목록 조회
	public FinancialStatementsDTO selectFinancialStatement();

}
