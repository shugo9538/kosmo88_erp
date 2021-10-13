package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

// 구매처 상품 DTO
@Alias("PurchaseItemListViewDTO")
public class PurchaseItemListViewDTO {
	private int item_id;				// 상품코드
	private String item_name;			// 상품명
	private String item_category;		// 종류
	private Date item_register_date;	// 상품 등록일
	private int item_price;				// 상품가격(구매원가)
	private String client_name;			// 거래처(구매처)
	private String client_register_num; // 사업자번호
	
	public PurchaseItemListViewDTO() {}

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

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_register_num() {
		return client_register_num;
	}

	public void setClient_register_num(String client_register_num) {
		this.client_register_num = client_register_num;
	}

}
