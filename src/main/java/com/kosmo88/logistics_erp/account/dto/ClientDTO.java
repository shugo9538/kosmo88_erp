package com.kosmo88.logistics_erp.account.dto;

import java.util.Date;

public class ClientDTO {
	
//	ID             NOT NULL NUMBER(5)     
//	TYPE           NOT NULL VARCHAR2(50)  
//	NAME           NOT NULL VARCHAR2(100) 
//	CEO_NAME       NOT NULL VARCHAR2(100) 
//	REGISTER_NUM   NOT NULL NUMBER(10)    
//	EMAIL          NOT NULL VARCHAR2(100) 
//	ADDRESS        NOT NULL VARCHAR2(100) 
//	REGISTER_DATE  NOT NULL DATE          
//	DETAIL_ADDRESS NOT NULL VARCHAR2(100) 
//	ZIP_CODE       NOT NULL NUMBER(5)
	
	private int id;
	private String type;
	private String name;
	private String ceo_name;
	private String register_num;	//int 범위가 넘어가서 long으로 변경
	private String address;
	private Date register_date;
	private String detail_address;
	private int zip_code;
	private String email;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCeo_name() {
		return ceo_name;
	}
	public void setCeo_name(String ceo_name) {
		this.ceo_name = ceo_name;
	}
	public String getRegister_num() {
		return register_num;
	}
	public void setRegister_num(String register_num) {
		this.register_num = register_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
