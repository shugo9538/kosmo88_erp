package com.kosmo88.logistics_erp.account.code;

public interface MenuCode {
	
/*	static int CLIENT = 110; //거래처 관리
	static int SLIP = 120; // 장부관리 - 일반전표
	static int SALESSLIP = 130; // 장부관리 - 매입/매출장
	static int PURCHASE = 131; // 매입전표 목록
	static String PURCHASE_NAME = "매입";
	static int SALES = 132; // 매출전표 목록
	static String SALES_NAME = "매출";
	static int ACCOUNT = 140; // 통장거래내역조회
	static int FINANCIAL = 150; // 결산/재무제표
*/	
	
	// 각 부서별 department_id
	// 각 부서별 요청 코드 departement_request
	
	//인사100 회계 200 영업 300 구매 400 물류 500
	
	int HR = 100;//   
	String HR_STATE = "RX_SALARY";
	String PAYMENT_STATE ="이체완료"; // 급여 일반전표 승인
	
	int ACCOUNT = 200;
	String ACCOUN_STATE  = "UTILITY_BILL";
	String ACCOUN_UTIL  = "UTILITY_BILL";
	
	int SALE = 300;
	String SALE_STATE = "RX_SALE";    
	
	int PURCHASE = 400;
	String PURCHASE_STATE = "TX_PURCHASE";
	
	int WMS = 500;
	String WMS_STATE = "SHIPPING";
	
	
	// 승인
	String CONFRIM = "Y";
	// 부서아이디 확인 되지 않음
	String ERROR = "error";
	// 승인상태가 아닌 전표 가 있을경우
	int NOT_APPROVED = 10;
	// 부서아이디 미확인
	int UNIDENTIFIED = 11;
	// 승인전표인경우
	int APPROVED = 12;
	// 전표 최종 상태 변경 및 승인
	int SUCCESS = 13;
	// 전표 승인완료 request_tbl 실패
	int FAIL = 14;
	
	
	
	
	
	

}
