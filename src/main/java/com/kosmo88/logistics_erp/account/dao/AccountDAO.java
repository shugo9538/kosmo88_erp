package com.kosmo88.logistics_erp.account.dao;

import java.util.List;
import java.util.Map;

import com.kosmo88.logistics_erp.account.dto.AccountDTO;
import com.kosmo88.logistics_erp.account.dto.BalanceDTO;
import com.kosmo88.logistics_erp.account.dto.ClientDTO;
import com.kosmo88.logistics_erp.account.dto.AccountHistoryDTO;
import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SalesSlipDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

public interface AccountDAO {
	
	// 기초정보관리
	// 거래처 목록건수
	public int getClientCnt();
	// 거래처 목록조회
	public List<ClientDTO> selectClient();
	// 신규 거래처 등록
	public int insertClient();
	// 거래처 정보 수정
	public int updeateClient(int register_num);
	// 거래처 목록 삭제
	public int deleteClient(int register_num);
	
	// 일반전표/장부관리
	// 일반전표 건수
	public int getSlipCnt();
	// 일반전표 조회
	public List<SlipDTO> selectSlipList();
	// 일반전표 단건조회
	public SlipDTO selectSlip(int id);
	// 일반전표 등록
	public int insertSlip(Map<String, Object> map);
	// 파트별 일반전표 승인 및 request 상태 변경 
	public int updateSlipState(Map<String, Object> map);
	public int updateRequestState(Map<String, Object> map);
	// 전표정보
	public List<SlipDTO> selectSlipInfo(Map<String, Object> slipmap);
	// 구매/영업 전표정보
	public List<SlipDTO> selectOrdrDetail(Map<String, Object> map);
	
	// 매입,매출장
	// 매입,매출장 조회
	public List<SalesSlipDTO> selectSalesSlip();
	// 매입전표 조회
	public List<SalesSlipDTO> selectPurchaseList();
	// 매출전표 조회
	public List<SalesSlipDTO> selectSalesList();
	// 매입/출전표 합계 (공급가액, 세액, 합계)
	public SalesSlipDTO selectSalesSlipSum();
	// 매입/매출 전표 계산서
	public int getSalesSlipCnt();
	// 매출 전표 생성 ( 영업팀 일반전표 승인시 ) 
	public int insertSalesSlip(Map<String, Object> map);
	// 매입 전표 생성 ( 구매팀 일반전표 승인시 ) 
	public int insertPurchaseSlip(Map<String, Object> map);

	
	
	// 금융자금관리
	// 통장 거래내역 건수
	public int getAccountCnt();
	// 통장 목록 조회 
	public List<AccountDTO> selectAccount();
	// 통장 추가처리
	public int insertAccount(AccountDTO accountDTO);
	// 통장 정보 미사용 처리
	public int updateAccountEnabled(String account_number);
	// 통장 목록 단순 조회(거래내역 추가페이지 계좌정보 뿌릴때)
	public AccountDTO selectAccountInfo(String account_number);
	// 통장테이블 계좌번호 중복조회
	public int accountNumberCheck(String account_number);
	// 통장 거래내역 추가
	public int insertAcountHistory(AccountHistoryDTO ahDTO);
	// 통장 잔액 업데이트
	public int updateAccountBalance(String account_number);
	// 통장 입출금 거래내역 상세페이지
	public List<BalanceDTO> selectAccountBalance(String account_number);
	
	// 결산/제무재표
	// 재무상태표
	public FinancialStatementsDTO selectFinancialStatements();
	// 손익계산서
	public IncomeStatementDTO selectIncomeStatement();
	
	

}
