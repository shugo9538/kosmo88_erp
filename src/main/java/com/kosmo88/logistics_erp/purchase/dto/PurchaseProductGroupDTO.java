package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

// 요청서 상품 그룹 DTO
public class PurchaseProductGroupDTO {
	
	private int id;					// 요청 상품 리스트 코드
	private int quantity;			// 상품 수량
	private int product_group;		// 그룹
	private int sales_price;		// 공급단가
	private int item_id;			// 상품 아이디
	
	public PurchaseProductGroupDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProduct_group() {
		return product_group;
	}

	public void setProduct_group(int product_group) {
		this.product_group = product_group;
	}

	public int getSales_price() {
		return sales_price;
	}

	public void setSales_price(int sales_price) {
		this.sales_price = sales_price;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
}
