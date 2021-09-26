package com.kosmo88.logistics_erp.account.dto;

import java.util.Date;
//매입/매출장 조회 DTO
public class SalesSlipDTO {
	
	private Date confirm_date; // 전표일자(slip 테이블 승인일자)  
	private int id; // 전표번호  
	private String account_title; // 계정과목   
	private int client_code; // 거래처코드   
	private String client_name; // 거래처명  
	private long client_num;// 사업자번호  
	private String product_name;// 품명  
	private int supply_amount;// 공급가액  
	private int tax_amount;// 세액 
	//private int supply_sum;// 공급가액 합계
	//private int tax_sum;// 세액합계
	//private int total_sum;
	private String type;// 유형  
	private String abs;// 요약
	private int slip_id;// 일반전표 ID
	
	
	
	public Date getConfirm_date() {
		return confirm_date;
	}
	public void setConfirm_date(Date confirm_date) {
		this.confirm_date = confirm_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_title() {
		return account_title;
	}
	public void setAccount_title(String account_title) {
		this.account_title = account_title;
	}
	public int getClient_code() {
		return client_code;
	}
	public void setClient_code(int client_code) {
		this.client_code = client_code;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public long getClient_num() {
		return client_num;
	}
	public void setClient_num(long client_num) {
		this.client_num = client_num;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getSupply_amount() {
		return supply_amount;
	}
	public void setSupply_amount(int supply_amount) {
		this.supply_amount = supply_amount;
	}
	public int getTax_amount() {
		return tax_amount;
	}
	public void setTax_amount(int tax_amount) {
		this.tax_amount = tax_amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public int getSlip_id() {
		return slip_id;
	}
	public void setSlip_id(int slip_id) {
		this.slip_id = slip_id;
	}
	
	
}
