package com.kosmo88.logistics_erp.account.code;

public interface menuCode {
	
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
	int HR = 1;
	String HR_STATE = "";
	String PAYMENT_STATE ="이체완료"; // 급여 일반전표 승인
	
	int PURCHASE = 200;
	String PURCHASE_STATE = "TX_PURCHASE";
	
	int SALE = 300;
	String SALE_STATE = "RX_SALE";
	
	int WMS = 400;
	String WMS_STATE = "";
	
	int ACCOUNT = 500;
	String ACCOUN_STATE  = "";
	
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
	
	// 성공
	int SUCCESS  = 13;
	
	
	
	
	
	

}
