package com.kosmo88.logistics_erp.sale.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

// 영업팀 주문서 전체 목록(조회) 뷰 DTO
@Alias("SalesOrderListViewDTO")
public class SalesOrderListViewDTO {
	
	private int request_id;			// 발주번호
	private Date begin_date;		// 발주일자
	private Date end_date;			// 납기요청일자
	private String client_name;		// 발주처
	private String client_ceo_name; // 발주처 대표자
	private String client_phone; 	// 발주처 연락처
	private String employee_name;	// 구매 담당자
	private String enabled;			// 활성화코드('Y', 'N')
	private String slip_state;		// 승인상태(전표 회계){R, Y, N}
	private String request_state;   // 출고상태{SALE, PURCHASE, ESTIMATE, ORDER}
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
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getSlip_state() {
		return slip_state;
	}
	public void setSlip_state(String slip_state) {
		this.slip_state = slip_state;
	}
	public String getRequest_state() {
		return request_state;
	}
	public void setRequest_state(String request_state) {
		this.request_state = request_state;
	}
	
	
}
