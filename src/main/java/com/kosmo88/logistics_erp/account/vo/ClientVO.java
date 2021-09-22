package com.kosmo88.logistics_erp.account.vo;

import java.util.Date;

public class ClientVO {
	
//	ID            NOT NULL NUMBER(5)     
//	TYPE          NOT NULL NUMBER(5)     
//	NAME          NOT NULL VARCHAR2(100) 
//	CEO_NAME      NOT NULL VARCHAR2(100) 
//	REGISTER_NUM  NOT NULL NUMBER(10)    
//	ADDRESS       NOT NULL VARCHAR2(100) 
//	REGISTER_DATE NOT NULL DATE 
	
	private int id;
	private int type;
	private String name;
	private String ceo_name;
	private long register_num;	//int 범위가 넘어가서 long으로 변경
	private String address;
	private Date register_date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
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
	public long getRegister_num() {
		return register_num;
	}
	public void setRegister_num(long register_num) {
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
	
	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", type=" + type + ", name=" + name + ", ceo_name=" + ceo_name + ", register_num="
				+ register_num + ", address=" + address + ", register_date=" + register_date + "]";
	}
	
}
