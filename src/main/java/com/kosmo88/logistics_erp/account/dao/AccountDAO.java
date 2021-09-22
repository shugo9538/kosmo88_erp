package com.kosmo88.logistics_erp.account.dao;

import java.util.List;
import java.util.Map;

import com.kosmo88.logistics_erp.account.vo.AccountVO;
import com.kosmo88.logistics_erp.account.vo.ClientVO;
import com.kosmo88.logistics_erp.account.vo.FinancialStatementsVO;
import com.kosmo88.logistics_erp.account.vo.SalesSlipVO;
import com.kosmo88.logistics_erp.account.vo.SlipVO;
import com.kosmo88.logistics_erp.account.vo.IncomeStatementVO;

public interface AccountDAO {
	
	// 기초정보관리
	// 거래처 목록건수
	public int getClientCnt();
	// 거래처 목록조회
	public List<ClientVO> selectClient(Map<String,Object> map);
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
	public List<SlipVO> selectSlip(Map<String,Object> map);
	// 일반전표 등록
	//public int insertSlip();
	// 파트별 전표승인
	//public int confirmSlip();
	// 일반전표 수정
	//public int updateSlip(int id);
	// 일반전표 상태변경 (승인/미승인)
	//public int updateSlipState(int id);
	// 일반전표 삭제
	//public int deleteSlip(int id);
	
	// 금융자금관리
	// 통장 거래내역 건수
	//public int getAccountCnt();
	// 통장 거래내역 조회 
	//public List<AccountVO> selectAccount(Map<String,Object> map);
	// 통장 목록조회
	// 통장 거래내역 추가
	//public int intsertAccountList();
	// 통장 출금내역 조회 (입금?출금?여부) 현재 구분 컬럼 없음
	//public int selectAccountWithdrawal(int state);
	// 통장 입금내역 조회 (입금?출금?여부) 현재 구분 컬럼 없음
	//public int selectAccountDeposit(int state);
	// 통장잔액조회 (전체조회에서 입출금잔액 불러와서 처리)
	// 급여통장 건수 (급여/거래처통장 구분??) 현재 구분 컬럼 없음
	//public int getSalaryAccountCnt();
	// 급여통장 조회  (급여/거래처통장 구분??) 현재 구분 컬럼 없음
	//public List<SalaryAccount>
	// 거래처통장 건수
	//
	// 거래처통장 조회
	//
	
	// 매입/매출장
	// 매입/매출전표 건수
	//public int getSalesSlipCnt();
	// 매입/매출전표 조회
	//public List<SalesSlipVO> selectSalesSlip(Map<String,Object> map);
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
	
	
	// 결산/제무재표
	// 재무상태표
	//public FinancialStatementsVO selectFinancialStatementsVO();
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
	//public IncomeStatementVO selectIncomeStatement();
	
	// 매출전표조회(합계) 상품매출
	// 상품매출원가(물류 상품매입가조회)
	// 판매관리비
	// 일반전표 인사팀 급여합계조회
	// 일반전표 인사팀 소모품비합계조회
	// 일반전표 물류팀 차량유지비 (유류비?)
	
	// 부채
	// 매입전표(외상매입금,부가세예수금) 합계조회
	
	

}
