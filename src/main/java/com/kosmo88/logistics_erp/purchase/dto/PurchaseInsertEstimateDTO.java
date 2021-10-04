package com.kosmo88.logistics_erp.purchase.dto;

// 견적서 등록 DTO
public class PurchaseInsertEstimateDTO {
	
	private int request_id;						// 거래처코드
	private int employee_id;					// 사원번호
	private int client_id;						// 거래처코드
	private int item_id;						// 상품코드
/*	 
 	한건
	1. REQUEST tbl
	
	employee_id 입력
	client_id 입력
	state 입력 TX_ESTIMATE
	
	다건
	2. PRODUCT_GROUP tbl
	quantity 입력
	item_id  입력
	
	한건
	3. REQ_PRODUCT_LIST
	RPL_SEQ.CURRVAL 입력
	REQUEST_SEQ.CURRVAL 입력

*/	
	public PurchaseInsertEstimateDTO() {}
	
	public int getRequest_id() {
		return request_id;
	}
	
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	
	public void setEmployee_id(int employee_id) {
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
	
}
