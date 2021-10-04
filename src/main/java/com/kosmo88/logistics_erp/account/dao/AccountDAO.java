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
	public List<ClientDTO> selectClient(Map<String,Object> map);
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
	public List<SlipDTO> selectSlip(Map<String,Object> map);
	// 일반전표 등록
	public int insertSlip(Map<String, Object> map);
	// 파트별 전표승인 
	public int updateSlipState(Map<String, Object> map);
	// 일반전표 수정
	//public int updateSlip(int id);
	// 일반전표 삭제
	//public int deleteSlip(int id);
	
	// 매입,매출장 목록
	public int getSalesPurchaseCnt(String type);
	// 매입, 매출 목록
	public List<SalesSlipDTO> selectSalesPurchase(Map<String, Object> map);
	// 매입,매출전표 건수
	public int getSalesSlipCnt();
	// 매입/매출전표 조회
	public List<SalesSlipDTO> selectSalesSlip(Map<String,Object> map);
	// 매출전표 건수
	//public int getSalesCnt(int type);
	// 매출전표 조회
	//public List<SalesSlipVO> selectSales(Map<String,Object> map);
	// 매입전표 건수
	//public int getPurchaseSlipCnt(int type);
	// 매입전표 조회
	//public List<SalesSlipVO> selectPurchase(Map<String,Object> map);
	// 매입/매출전표 추가
	//public int insertSalesSlip();
	// 매입/매출전표 수정
	//public int updateSalesSlip(int id);
	// 매입/매출전표 삭제
	//public int deleteSalesSlip(int id);
	
	// 금융자금관리
	// 통장 거래내역 건수
	public int getAccountCnt();
	// 통장 목록 조회 
	public List<AccountDTO> selectAccount(Map<String,Object> map);
	// 통장 추가처리
	public int insertAccount(AccountDTO accountDTO);
	// 통장 목록 단순 조회(거래내역 추가페이지 계좌정보 뿌릴때)
	public List<AccountDTO> selectAccountInfo();
	// 통장 거래내역 추가
	public int insertAcountHistory(AccountHistoryDTO ahDTO);
	// 통장 입출금 거래내역 상세페이지
	public List<BalanceDTO> selectAccountBalance(String account_number);
	
	// 결산/제무재표
	// 재무상태표
	public FinancialStatementsDTO selectFinancialStatements();
	// 거래처통장조회(합계) 보통예금
	//public int sumAccount();  // 다른정보와 함께 받으려면 vo로 받고 해당컬럼 별칭 합계만 받을때는 resultType int로
	// 매출전표조회(합계) 외상매출금 (공급가액) 부가세대급금 (세액)
	//public int sumSalesSlip(int type);
	// 재고자산조회(상품) 재고 *가격 (물류 재고량 * 상품거래처매입가)
	//public int getWarehouseProductCnt();
	//public int sumPurchasePrice();
	// 매입전표조회(합계) 외상매입금 (공급가액) 부가세예수금 (세액)
	//public int sumPurchaseSlip(int type);
	
	// 손익계산서
	public IncomeStatementDTO selectIncomeStatement();
	
	// 매출전표조회(합계) 상품매출
	// 상품매출원가(물류 상품매입가조회)
	// 판매관리비
	// 일반전표 인사팀 급여합계조회
	// 일반전표 인사팀 소모품비합계조회
	// 일반전표 물류팀 차량유지비 (유류비?)
	
	// 부채
	// 매입전표(외상매입금,부가세예수금) 합계조회
	
	

}
