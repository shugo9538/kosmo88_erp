package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

// 거래처 등록 DTO
public class PurchaseRequestDTO {
	
	private int id;					// 요청서코드
	private Date begin_date;		// 요청(시작)일자
	private Date end_date;			// 종료(납기)일자
	private String state;			// 상태(RX/TX, SALE, PURCHASE, ESTIMATE, ORDER)
	private String employee_id;		// 회사 담당자
	private int client_id;			// 거래처코드
	
	public PurchaseRequestDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	
}