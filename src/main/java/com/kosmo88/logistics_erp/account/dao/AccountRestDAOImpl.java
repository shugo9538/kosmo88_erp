package com.kosmo88.logistics_erp.account.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

@Repository
public class AccountRestDAOImpl implements AccountRestDAO  {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountRestDAOImpl.class);

	private final String STATEMENT = "com.kosmo88.logistics_erp.account.dao.AccountRestDAO";
	
	@Autowired
	SqlSession sqlSession;
	
	// 일반전표 세부부내역
	@Override
	public List<SlipDTO> selectSlipInfo(int slip_id) {
		 List<SlipDTO> list = sqlSession.selectList(STATEMENT +  ".selectSlipInfo", slip_id);
		 return list;
	}
	
	// 손익계산서조회
	public IncomeStatementDTO selectIcomeStatement() {
		IncomeStatementDTO imcome = sqlSession.selectOne(STATEMENT + ".selectIcomeStatement");
		return imcome;
	}
	
	// 재무상태표 조회
	@Override
	public FinancialStatementsDTO selectFinancialStatement() {
		logger.info("재무상태표 조회 ");
		FinancialStatementsDTO financial = sqlSession.selectOne(STATEMENT + ".financialStatement");
		return financial;
	}
	
}
