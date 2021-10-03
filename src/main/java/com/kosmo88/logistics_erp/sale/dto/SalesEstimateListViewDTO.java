package com.kosmo88.logistics_erp.sale.dto;

import java.util.Date;

public class SalesEstimateListViewDTO {

	private int request_id;			// 견적번호
	private Date begin_date;		// 요청일자
	private String client_name;		// 거래처명
	private String client_ceo_name; // 거래처대표자명
	private String client_phone; 	// 거래처연락처
	private String client_email;    // 거래처 이메일
	private String employee_name;	// 담당자
	private String employee_dp;		// 담당자 부서
	private String employee_phone;  // 담당자 연락처
	private String employee_email;  // 담당자 이메일
	private String request_state;	// 상태
	private String enabled;			// 활성화코드('Y', 'N')
	
	public SalesEstimateListViewDTO() {}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_ceo_name() {
		return client_ceo_name;
	}

	public void setClient_ceo_name(String client_ceo_name) {
		this.client_ceo_name = client_ceo_name;
	}

	public String getClient_phone() {
		return client_phone;
	}

	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getRequest_state() {
		return request_state;
	}

	public void setRequest_state(String request_state) {
		this.request_state = request_state;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getClient_email() {
		return client_email;
	}

	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}

	public String getEmployee_dp() {
		return employee_dp;
	}

	public void setEmployee_dp(String employee_dp) {
		this.employee_dp = employee_dp;
	}

	public String getEmployee_phone() {
		return employee_phone;
	}

	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	
	
}
