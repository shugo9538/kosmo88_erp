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
	
	int HR = 1;//   
	String HR_STATE = "RX_SALARY";
	String PAYMENT_STATE ="이체완료"; // 급여 일반전표 승인
	
	int ACCOUNT = 200;
	String ACCOUN_STATE  = "UTILITY_BILL";
	String ACCOUN_UTIL  = "UTILITY_BILL";
	
	int SALE = 300;
	String SALES_STATE = "RX_SALES";    
	
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
	// 매출전표 발행 실패
	int SLIP_CREATE_FAIL = 15;
	// 요청코드 실패
	int REQUEST_CODE_FAIL = 16;
	// 사원번호 유/무
	int EMPLOYEE_ID = 17;
	//  지출결의 등록 실패
	int EXPENSE = 18; 
	
	
	// 안드로이드 디바이스 토큰
	String SEND = "d9ZLQRsbSWuNhewbzkBs7j:APA91bE4g3pc6rxsj9uuMkQ-Nl-5LNrdkJWplQvKzvAQhvCoPNme6FYKO9Yre2aFsc2aL2PGSA_0m5OAdpJCZGZT69angZNczVqauVorLKICm9rB2BWzqKHZ3_snAOaI4v7i0ub-9jPJ";
	String COMPANY = "KU ERP Kosmo Ultimate ERP"; 
	
	// 승인 안내
	String HR_SEND = "인사팀 급여전표 승인 및 이체가 완료되었습니다. \n 즐거운 하루 보내세요~"; 
	String SALES_SEND = "영업팀 전표승인 완료 되었습니다.";
	String PURCHASE_SEND = "영업팀 전표승인 완료 되었습니다.";
	String ACCOUNT_SEND = " 요청하신 판매관리비 전표승인 처리 되었습니다.";
	
	//알람
	String ALERT = "";
	
	
	
	

}
