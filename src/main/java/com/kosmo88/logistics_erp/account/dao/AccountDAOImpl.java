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
		return sqlSession.selectOne(STATEMENT + ".getClientCnt");
	}
	// 거래처 목록조회
	@Override
	public List<ClientDTO> selectClient() {
		return sqlSession.selectList(STATEMENT + ".selectClient");
	}
	// 신규 거래처 등록
	@Override
	public int insertClient() {
		return sqlSession.insert(STATEMENT + ".insertClient");
	}
	// 거래처 정보 수정
	@Override
	public int updeateClient(int register_num) {
		return sqlSession.update(STATEMENT + ".updeateClient", register_num);
	}
	// 거래처 목록 삭제
	@Override
	public int deleteClient(int register_num) {
		return sqlSession.delete(STATEMENT + ".deleteClient", register_num);
	}
	
	// ------------------------------ 일반전표/장부관리 ------------------------------
	// 일반전표 건수
	@Override
	public int getSlipCnt() {
		return sqlSession.selectOne(STATEMENT + ".getSlipCnt");
	}
	// 일반전표 조회
	@Override
	public List<SlipDTO> selectSlipList() {
		return sqlSession.selectList(STATEMENT + ".selectSlipList");
	}
	// 일반전표 단건 조회
	@Override
	public SlipDTO selectSlip(int id) {
		return sqlSession.selectOne(STATEMENT + ".selectSlip", id);
	}
	// 일반전표 등록 (parameter 로 int department_id, int department_request)
	@Override
	public int insertSlip(SlipDTO slipDTO) {
		return sqlSession.insert(STATEMENT + ".insertSlip", slipDTO);
	}
	@Override
	public int insertRequest(SlipDTO slipDTO) {
		return sqlSession.insert(STATEMENT + ".insertRequest", slipDTO);
	}
	@Override
	public int insertOperating_expense(SlipDTO slipDTO) {
		return sqlSession.insert(STATEMENT + ".insertOperating_expense", slipDTO);
	}

	// 일반전표 - 부서별 승인 처리  
	@Override
	public int updateSlipState(Map<String, Object> map) {
		System.out.println("updateSlipState : " + map);
		return sqlSession.update("com.kosmo88.logistics_erp.account.dao.AccountDAO.updateSlipState", map);
	}
	// 일반전표 승인 후 request tbl 상태 변경
	@Override
	public int updateRequestState(Map<String, Object> map) {
		System.out.println("updateRequestState : " + map);
		return sqlSession.update("com.kosmo88.logistics_erp.account.dao.AccountDAO.updateRequestState", map);
	}
	// 일반전표 상세내역1
	@Override
	public List<SlipDTO> selectSlipInfo(Map<String, Object> map) {
		System.out.println("selectSlipInfo : " + map);
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectSlipInfo", map);
	}
	// 일반전표 - 상세내역2
	@Override
	public SlipDTO selectOrdrDetail(Map<String, Object> map) {
		System.out.println("selectOrdrDetail : " + map);
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectOrdrDetail", map);
	}

	
	// ------------------------------ 매입/매출전표 ------------------------------
	// 매입매출장 조회
	@Override
	public List<SalesSlipDTO> selectSalesSlip() {
		return sqlSession.selectList(STATEMENT + ".selectSalesSlip");
	}
	// 매입전표 조회
	@Override
	public List<SalesSlipDTO> selectPurchaseList(){
		return sqlSession.selectList(STATEMENT + ".selectPurchaseList"); 
	
	}
	// 매출전표 조회
	@Override
	public List<SalesSlipDTO> selectSalesList() {
		return sqlSession.selectList(STATEMENT + ".selectSalesList"); 
	}
	// 매입,매출전표 공급가액/세액 합계
	@Override
	public SalesSlipDTO selectSalesSlipSum() {
		return sqlSession.selectOne(STATEMENT +  ".selectSalesSlipSum");
	}
	// 매입,매출전표 공급가액/세액 합계
	@Override
	public SalesSlipDTO selectSalesSum() {
		return sqlSession.selectOne(STATEMENT +  ".selectSalesSum");
	}
	// 매입,매출전표 공급가액/세액 합계
	@Override
	public SalesSlipDTO selectPurchaseeSum() {
		return sqlSession.selectOne(STATEMENT +  ".selectPurchaseeSum");
	}
	// 매입 매출전표 건수
	@Override
	public int getSalesSlipCnt() {
		return sqlSession.selectOne(STATEMENT +  ".getSalesSlipCnt");
	}
	@Override
	public int getSalesCnt() {
		return sqlSession.selectOne(STATEMENT +  ".getSalesCnt");
	}
	@Override
	public int getPurchaseeCnt() {
		return sqlSession.selectOne(STATEMENT +  ".getPurchaseeCnt");
	}
	// 일반전표 승인 후 (영업) 매출 전표 생성
	@Override
	public int insertSalesSlip(Map<String, Object> map) {
		System.out.println("insertSalesSlip : " + map);
		return sqlSession.insert(STATEMENT +  ".insertSalesSlip", map);
	}
	// 일반전표 승인 후 (구매) 매입 전표 생성
	@Override
	public int insertPurchaseSlip(Map<String, Object> map) {
		System.out.println("insertPurchaseSlip : " + map);
		return sqlSession.insert(STATEMENT +  ".insertPurchaseSlip", map);
	}

	// ------------------------------ 금융/자금관리 ------------------------------
	// 계좌 건수조회
	@Override
	public int getAccountCnt() {
		return sqlSession.selectOne(STATEMENT + ".getAccountCnt");
	}
	// 계좌 목록조회
	@Override
	public List<AccountDTO> selectAccount() {
		return sqlSession.selectList(STATEMENT + ".selectAccountList");
	}
	// 등록 계좌정보 조회(계좌거래내역 등록시 계좌정보)
	@Override
	public AccountDTO selectAccountInfo(String account_number) {
		return sqlSession.selectOne(STATEMENT + ".selectAccountInfo", account_number);
	}
	// 계좌테이블 계좌번호 중복조회
	@Override
	public int accountNumberCheck(String account_number) {
		return sqlSession.selectOne(STATEMENT + ".accountNumberCheck", account_number);
	}
	// 신규통장 추가처리
	@Override
	public int insertAccount(AccountDTO accountDTO) {
		return sqlSession.insert(STATEMENT + ".insertAccount", accountDTO);
	}
	// 등록통장 정보수정
	@Override
	public int updateAccountEnabled(String account_number) {
		
		return sqlSession.update(STATEMENT + ".updateAccountEnabled", account_number);
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
	//통장 잔액 업데이트
	@Override
	public int updateAccountBalance(String account_number) {
		return sqlSession.insert(STATEMENT + ".updateAccountBalance", account_number);
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
