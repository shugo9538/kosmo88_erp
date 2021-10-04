package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

// 구매팀 견적서 상세페이지 뷰 DTO
public class PurchaseEstimateDetailViewDTO {
	
	private int request_id;				// 견적번호
	private Date begin_date;			// 요청일자
	private String employee_name;		// 담당자
	private String employee_phone;		// 담당자연락처
	private String employee_email;		// 담당자 이메일
	private String client_name;			// 거래처명
	private String client_ceo_name;		// 거래처대표자명
	private String client_phone;		// 거래처 연락처
	private String client_email;		// 거래처 이메일
	private int item_quantity;			// 상품 수량
	private String item_name;			// 상품명
	private String item_category;		// 종류
	private int item_purchase_price;    // 공급단가
	private String department_name; 	// 부서명
	
	public PurchaseEstimateDetailViewDTO() {}

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

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
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

	public String getClient_email() {
		return client_email;
	}

	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public int getItem_purchase_price() {
		return item_purchase_price;
	}

	public void setItem_purchase_price(int item_purchase_price) {
		this.item_purchase_price = item_purchase_price;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
}
