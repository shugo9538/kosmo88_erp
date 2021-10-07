package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

// 거래처 DTO
public class PurchaseRPLDTO {
	
	private int id;				// 요청 상품 리스트 코드
	private int product_group;	// 상품목록코드
	private int request_id;		// 요청서코드
	
	public PurchaseRPLDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_group() {
		return product_group;
	}

	public void setProduct_group(int product_group) {
		this.product_group = product_group;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}	
}	
