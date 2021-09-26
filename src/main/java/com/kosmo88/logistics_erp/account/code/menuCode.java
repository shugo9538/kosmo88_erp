package com.kosmo88.logistics_erp.account.code;

public interface menuCode {
	
	static int CLIENT = 110; //거래처 관리
	
	static int SLIP = 120; // 장부관리 - 일반전표
	
	static int SALESSLIP = 130; // 장부관리 - 매입/매출장
	static int SALES = 131; // 매출전표 목록
	static String SALES_NAME = "매입";
	static int PURCHASE = 132; // 매입전표 목록
	static String PURCHASE_NAME = "매출";
	
	static int ACCOUNT = 140; // 통장거래내역조회
	
	static int FINANCIAL = 150; // 결산/재무제표
	
	
	
	

}
