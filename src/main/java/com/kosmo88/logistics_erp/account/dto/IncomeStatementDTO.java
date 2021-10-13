package com.kosmo88.logistics_erp.account.dto;

import org.apache.ibatis.type.Alias;

@Alias("IncomeStatementDTO")
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
	private long sales_cost; 
	
	// 상품매출원가
	private long basic_product;  // 기초 상품 재고액 (가데이터 - 전기분이 없음)
	private long current_product;  // 당기 상품 매입액 
	//private int endProduct; // 기말 상품 매입액
	
	//판매관리비 private int administrativeExpenses;
	private long employee_salary; //직원급여
	private long employee_benefits; //복리후생비
	private long travel_expenses; //여비교통비
	private long entertainment; //접대비
	private long communication_cost; //통신비
	private long water_utility_bill; //수도광열비
	private long taxes_and_duties; //세금과공과금
	private long paid_rent; //지급임차료
	private long premium; //보험료
	private long vehicle_maintenance_cost; //차량유지비
	private long office_supplies; //사무용품비
	private long consumables_cost; //소모품비
	private long interest_income; //이자수익
	private long interest_expense; //이자비용
	private long corporate_tax; //법인세비용
	
	private long net_income;

	public long getSales_cost() {
		return sales_cost;
	}

	public void setSales_cost(long sales_cost) {
		this.sales_cost = sales_cost;
	}

	public long getBasic_product() {
		return basic_product;
	}

	public void setBasic_product(long basic_product) {
		this.basic_product = basic_product;
	}

	public long getCurrent_product() {
		return current_product;
	}

	public void setCurrent_product(long current_product) {
		this.current_product = current_product;
	}

	public long getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(long employee_salary) {
		this.employee_salary = employee_salary;
	}

	public long getEmployee_benefits() {
		return employee_benefits;
	}

	public void setEmployee_benefits(long employee_benefits) {
		this.employee_benefits = employee_benefits;
	}

	public long getTravel_expenses() {
		return travel_expenses;
	}

	public void setTravel_expenses(long travel_expenses) {
		this.travel_expenses = travel_expenses;
	}

	public long getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(long entertainment) {
		this.entertainment = entertainment;
	}

	public long getCommunication_cost() {
		return communication_cost;
	}

	public void setCommunication_cost(long communication_cost) {
		this.communication_cost = communication_cost;
	}

	public long getWater_utility_bill() {
		return water_utility_bill;
	}

	public void setWater_utility_bill(long water_utility_bill) {
		this.water_utility_bill = water_utility_bill;
	}

	public long getTaxes_and_duties() {
		return taxes_and_duties;
	}

	public void setTaxes_and_duties(long taxes_and_duties) {
		this.taxes_and_duties = taxes_and_duties;
	}

	public long getPaid_rent() {
		return paid_rent;
	}

	public void setPaid_rent(long paid_rent) {
		this.paid_rent = paid_rent;
	}

	public long getPremium() {
		return premium;
	}

	public void setPremium(long premium) {
		this.premium = premium;
	}

	public long getVehicle_maintenance_cost() {
		return vehicle_maintenance_cost;
	}

	public void setVehicle_maintenance_cost(long vehicle_maintenance_cost) {
		this.vehicle_maintenance_cost = vehicle_maintenance_cost;
	}

	public long getOffice_supplies() {
		return office_supplies;
	}

	public void setOffice_supplies(long office_supplies) {
		this.office_supplies = office_supplies;
	}

	public long getConsumables_cost() {
		return consumables_cost;
	}

	public void setConsumables_cost(long consumables_cost) {
		this.consumables_cost = consumables_cost;
	}

	public long getInterest_income() {
		return interest_income;
	}

	public void setInterest_income(long interest_income) {
		this.interest_income = interest_income;
	}

	public long getInterest_expense() {
		return interest_expense;
	}

	public void setInterest_expense(long interest_expense) {
		this.interest_expense = interest_expense;
	}

	public long getCorporate_tax() {
		return corporate_tax;
	}

	public void setCorporate_tax(long corporate_tax) {
		this.corporate_tax = corporate_tax;
	}

	public long getNet_income() {
		return net_income;
	}

	public void setNet_income(long net_income) {
		this.net_income = net_income;
	}

}
