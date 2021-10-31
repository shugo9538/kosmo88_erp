package com.kosmo88.logistics_erp.wms.dto;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Alias("PurchaseAndSaleDto")
public class PurchaseAndSaleDto {

	private int item_id;
	private String item_name;
	private int quantity_purchase;
	private int quantity_sales;

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

	public int getQuantity_purchase() {
		return quantity_purchase;
	}

	public void setQuantity_purchase(int quantity_purchase) {
		this.quantity_purchase = quantity_purchase;
	}

	

	public int getQuantity_sales() {
		return quantity_sales;
	}

	public void setQuantity_sales(int quantity_sales) {
		this.quantity_sales = quantity_sales;
	}

	@Override
	public String toString() {
		return "PurchaseAndSaleDto [item_id=" + item_id + ", item_name=" + item_name + ", quantity_purchase="
				+ quantity_purchase + ", quantity_sales=" + quantity_sales + "]";
	}

	
	

	
}
