package com.kosmo88.logistics_erp.account.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.account.dto.AccountDTO;
import com.kosmo88.logistics_erp.account.dto.BalanceDTO;
import com.kosmo88.logistics_erp.account.dto.ClientDTO;
import com.kosmo88.logistics_erp.account.dto.AccountHistoryDTO;
import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SalesSlipDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private final String STATEMENT = "com.kosmo88.logistics_erp.account.dao.AccountDAO";
	
	@Autowired
	SqlSession sqlSession;
	
	// ------------------------------ 기초정보관리 ------------------------------
	// 거래처 목록건수
	@Override
	public int getClientCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getClientCnt");
	}
	// 거래처 목록조회
	@Override
	public List<ClientDTO> selectClient() {
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectClient");
	}
	// 신규 거래처 등록
	@Override
	public int insertClient() {
		return sqlSession.insert("com.kosmo88.logistics_erp.account.dao.AccountDAO.insertClient");
	}
	// 거래처 정보 수정
	@Override
	public int updeateClient(int register_num) {
		return sqlSession.update("com.kosmo88.logistics_erp.account.dao.AccountDAO.updeateClient", register_num);
	}
	// 거래처 목록 삭제
	@Override
	public int deleteClient(int register_num) {
		return sqlSession.delete("com.kosmo88.logistics_erp.account.dao.AccountDAO.deleteClient", register_num);
	}
	
	// ------------------------------ 일반전표/장부관리 ------------------------------
	// 일반전표 건수
	@Override
	public int getSlipCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getSlipCnt");
	}
	// 일반전표 조회
	@Override
	public List<SlipDTO> selectSlip() {
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectSlip");
	}
	// 일반전표 등록 (parameter 로 int department_id, int department_request)
	@Override
	public int insertSlip(Map<String, Object> map) {
		return sqlSession.insert("com.kosmo88.logistics_erp.account.dao.AccountDAO.insertSlip", map);
	}
	// 일반전표 상태업데이트 (Y/N) 승인/미승인 (parameter 로 int department_id, int department_request)  
	@Override
	public int updateSlipState(Map<String, Object> map) {
		return sqlSession.update("com.kosmo88.logistics_erp.account.dao.AccountDAO.updateSlipState", map);
	}
	
	
	// ------------------------------ 매입/매출전표 ------------------------------
	// 매입/매출전표 건수
	@Override
	public int getSalesSlipCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getSalesSlipCnt");
	}
	// 매입or매출 전표 건수조회
	@Override
	public int getSalesPurchaseCnt(String type) {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getSalesPurchaseCnt", type); 
	}
	
	// 공급가액 합계조회
	// 세액 합계조회
	// 공급가액  + 세액 합계조회
	// 매입/매출전표 전체목록
	@Override
	public List<SalesSlipDTO> selectSalesSlip() {
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectSalesSlip");
	}
	// 매입or매출 전표 목록 조회
	@Override
	public List<SalesSlipDTO> selectSalesPurchase(Map<String, Object> map){
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectSalesPurchase", map); 
	
	}
	// ------------------------------ 금융/자금관리 ------------------------------
	// 계좌 건수조회
	@Override
	public int getAccountCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getAccountCnt");
	}
	// 계좌 목록조회
	@Override
	public List<AccountDTO> selectAccount() {
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectAccountList");
	}
	// 등록 계좌정보 조회(계좌거래내역 등록시 계좌정보)
	@Override
	public AccountDTO selectAccountInfo(String account_number) {
		System.out.println("dbdbdbdbdbdb");
		return sqlSession.selectOne(STATEMENT + ".selectAccountInfo", account_number);
	}
	// 계좌번호 중복조회
	@Override
	public int accountConfrim(String account_number) {
		return sqlSession.selectOne(STATEMENT + ".accountConfrim");
	}
	// 신규통장 추가처리
	@Override
	public int insertAccount(AccountDTO accountDTO) {
		return sqlSession.insert(STATEMENT + ".insertAccount", accountDTO);
	}
	// 통장 잔액조회
	@Override
	public List<BalanceDTO> selectAccountBalance(String account_number) {
		return sqlSession.selectList(STATEMENT + ".selectAccountBalance", account_number);
	}
	//통장 거래내역 추가
	@Override
	public int insertAcountHistory(AccountHistoryDTO ahDTO) {
		System.out.println("dddd : "+ ahDTO);
		return sqlSession.insert(STATEMENT + ".insertAcountHistory", ahDTO);
	}
	
	
	
	// ------------------------------ 결산/재무제표 ------------------------------
	// 제무재표
	@Override
	public FinancialStatementsDTO selectFinancialStatements() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.financialstatements");
	}
	// 손익계산서
	@Override
	public IncomeStatementDTO selectIncomeStatement() {
		return sqlSession.selectOne(STATEMENT + ".incomeStatement");
	}








	
	
	
	
	
}
