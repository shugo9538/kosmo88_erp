package com.kosmo88.logistics_erp.account.dto;

public class IncomeStatementDTO {
	
// 손익계산서
// 상품매출 - 매입/매출전표에서 외상매출금 (세액제외 가져오기)
// 상품매출원가 - 물류창고 재고개수 * 매출/매입전표 외상매입금(세액제외)
// 판매관리비 - 급여, 소모품비, 기타
// 

	
//     순매출액 = 총매출액-매입에누리,매입할인,매입환출 
// 순매출액 (총매출액-매출에누리,매출할인,매출환입)
// 매출원가 ( 기초상품재고액 + 당기상품매입액(순매입액) - 기말상품재고액 )
// ----------				순매입액 = 총매입액-매입에누리,매입할인,매입환출     
// 매출총이익
// - 판매비 및 관리비								*(운반비) 매입 : 총매입엑에 더한다(가산) / 매출 : 운반비계정과목 별도처리
//--------
// 영업이익
// + 영업외수익													
// - 영업외비용
//--------
// 법이세차감전순이익
// - 법인세비용
//--------
// 당기순이익
	
	//매출원가
	private int sales_cost; 
	
	// 상품매출원가
	private int basic_product;  // 기초 상품 재고액 (가데이터 - 전기분이 없음)
	private int current_product;  // 당기 상품 매입액 
	//private int endProduct; // 기말 상품 매입액
	
	//판매관리비 private int administrativeExpenses;
	private int employee_salary; //직원급여

	
	//이자수익
	//이자비용
	//법인세비용
	//당기순이익
	
	public int getSales_cost() {
		return sales_cost;
	}

	public void setSales_cost(int sales_cost) {
		this.sales_cost = sales_cost;
	}

	public int getBasic_product() {
		return basic_product;
	}

	public void setBasic_product(int basic_product) {
		this.basic_product = basic_product;
	}

	public int getCurrent_product() {
		return current_product;
	}

	public void setCurrent_product(int current_product) {
		this.current_product = current_product;
	}

	public int getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(int employee_salary) {
		this.employee_salary = employee_salary;
	}
	
}
