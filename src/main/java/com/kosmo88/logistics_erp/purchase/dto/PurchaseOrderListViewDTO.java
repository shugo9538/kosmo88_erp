package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

// 구매팀 주문서 전체 목록(조회) 뷰 DTO
public class PurchaseOrderListViewDTO {
	
<<<<<<< HEAD
	private int request_id;			// 주문번호
	private String client_name;		// 거래처명
	private String ceo_name;		// 거래처대표자명
	private String employee_name;	// 담당자명
	private Date request_date;		// 주문일자
=======
	private int request_id;			// 발주번호
	private Date begin_date;		// 발주일자
	private Date end_date;			// 납기요청일자   -- 추가
	private String client_name;		// 발주처
	private String client_ceo_name; // 발주처 대표자
	private String client_phone; 	// 발주처 연락처
	private String employee_name;	// 구매 담당자
	private String request_state;	// 상태
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
	private String enabled;			// 활성화코드('Y', 'N')
	
	public PurchaseOrderListViewDTO() {}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getCeo_name() {
		return ceo_name;
	}

	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
}
