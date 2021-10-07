package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

// 구매 주문 상품 DTO
@Alias("PurchaseOrderItemDTO")
public class PurchaseOrderItemDTO {
	private int item_id;				// 상품코드
	private String item_name;			// 상품명
	private String item_category;		// 종류
	private Date item_register_date;    // 상품 등록일
	private int item_price;				// 상품가격(구매원가)
	private int item_quantity;			// 상품 수량
	private int request_id;				// 견적서 코드
	
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
	
	
	public PurchaseOrderItemDTO() {}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
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

	public Date getItem_register_date() {
		return item_register_date;
	}

	public void setItem_register_date(Date item_register_date) {
		this.item_register_date = item_register_date;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

}
