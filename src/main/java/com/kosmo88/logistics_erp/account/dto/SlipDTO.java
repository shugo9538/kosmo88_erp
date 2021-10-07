package com.kosmo88.logistics_erp.account.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("SlipDTO")
public class SlipDTO {
	
	private int id;
	private String type;
	private Date register_date;
	private Date update_date;
	private String state;
	private int department_id;
	private int department_request;

	
	// 매입,매출전표 생성시 필요 컬럼
	private int request_id;
	private int sales_price;
	private int quantity;
	private int total;
	
	private String item_name;
	
	private int sum_supply;
	private int sum_tax;
	private int sum_total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getDepartment_request() {
		return department_request;
	}
	public void setDepartment_request(int department_request) {
		this.department_request = department_request;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getSales_price() {
		return sales_price;
	}
	public void setSales_price(int sales_price) {
		this.sales_price = sales_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getSum_supply() {
		return sum_supply;
	}
	public void setSum_supply(int sum_supply) {
		this.sum_supply = sum_supply;
	}
	public int getSum_tax() {
		return sum_tax;
	}
	public void setSum_tax(int sum_tax) {
		this.sum_tax = sum_tax;
	}
	public int getSum_total() {
		return sum_total;
	}
	public void setSum_total(int sum_total) {
		this.sum_total = sum_total;
	}
	
	
	@Override
	public String toString() {
		return "SlipDTO [id=" + id + ", type=" + type + ", register_date=" + register_date + ", update_date="
				+ update_date + ", state=" + state + ", department_id=" + department_id + ", department_request="
				+ department_request + ", request_id=" + request_id + ", sales_price="
				+ sales_price + ", quantity=" + quantity + ", total=" + total + ", item_name=" + item_name
				+ ", sum_supply=" + sum_supply + ", sum_tax=" + sum_tax + ", sum_total=" + sum_total + "]";
	}
}
