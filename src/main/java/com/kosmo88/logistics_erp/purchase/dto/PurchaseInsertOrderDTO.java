package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

// 주문서 등록 DTO
@Alias("PurchaseInsertOrderDTO")
public class PurchaseInsertOrderDTO {
	
	private int request_id;						// 거래처코드
	private String employee_id;					// 사원번호
	private int client_id;						// 거래처코드
	private int item_id;						// 상품코드
	private int department_id;					// 부서코드
	private int quantity;						// 상품수량
	private Date end_date;						// 납기요청일자
	
/*	 
 	한건
	1. REQUEST tbl
	
	employee_id 입력
	client_id 입력
	state 입력 TX_ORDER
	end_date 입력
	
	한건
	2. slip tbl
	
	department_id 입력
	department_request 입력 - request_seq.currval
	type 입력  WITHDRAW
	
	다건
	3. PRODUCT_GROUP tbl
	quantity 입력
	item_id  입력
	
	한건
	4. REQ_PRODUCT_LIST
	RPL_SEQ.CURRVAL 입력
	REQUEST_SEQ.CURRVAL 입력

*/	
	public PurchaseInsertOrderDTO() {}

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

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
