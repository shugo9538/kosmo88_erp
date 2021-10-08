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
	
	// 전표 상세정보시 필요 컬럼
	private int purchase_price;
	private int slip_id;
	private int client_id;
	private String client_name;
	private String client_ceo_name;
	private String client_num;
	private String client_phone;
	private String client_email;
	private String employee_id;
	private String employee_photo;
	private String employee_name;
	private String employee_phone;
	private String employee_email;
	private Date hire_date;
	
	private String department_name;
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
	public int getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}
	public int getSlip_id() {
		return slip_id;
	}
	public void setSlip_id(int slip_id) {
		this.slip_id = slip_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
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
	public String getClient_num() {
		return client_num;
	}
	public void setClient_num(String client_num) {
		this.client_num = client_num;
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
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_photo() {
		return employee_photo;
	}
	public void setEmployee_photo(String employee_photo) {
		this.employee_photo = employee_photo;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
}
