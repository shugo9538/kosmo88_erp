package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

// 구매 상품 DTO
@Alias("PurchaseItemDTO")
public class PurchaseItemDTO {
	private int id;					// 상품코드
	private String name;			// 상품명
	private String category;		// 종류
	private Date register_date;		// 상품 등록일
	private int price;				// 상품가격(구매원가)
	private int quantity;			// 상품 수량
	
	public PurchaseItemDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
