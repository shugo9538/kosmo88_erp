package com.kosmo88.logistics_erp.sale.dto;

import org.apache.ibatis.type.Alias;

@Alias("SalesInsertEstimateDTO")
public class SalesInsertEstimateDTO {

	private int request_id;						// 견적서 코드	
	private String employee_id;					// 사원번호	
	private int client_id;						// 거래처코드   
	private int item_id;						// 상품코드
	private int request_state;					// 리퀘스트 
	
	public SalesInsertEstimateDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getRequest_state() {
		return request_state;
	}

	public void setRequest_state(int request_state) {
		this.request_state = request_state;
	}
	
	
	
}
