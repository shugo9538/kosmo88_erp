package com.kosmo88.logistics_erp.sale.dto;

import java.util.Date;

public class SalesClientDTO {
	
	private int id;              		//NUMBER(5),                    -- 거래처코드  pk
    private String type;            	//varchar2(50)         NOT NULL,   -- 거래유형
    private String name;           		// VARCHAR2(100)     NOT NULL,   -- 거래처명
    private String ceo_name;       		// VARCHAR2(100)     NOT NULL,   -- 대표자명
    private long register_num;   		// NUMBER(10)        NOT NULL,   -- 사업자번호
    private String email;                // VARCHAR2(100) NOT NULL,
    private String address;        		// VARCHAR2(100)     NOT NULL,   -- 주소
    private String detail_address; 		//varchar2(100)    NOT NULL,
    private int zip_code;    			// number(5)       not null,
    private Date register_date;   	//DATE              NOT NULL,   -- 거래처 등록일
	private int phone;              // NUMBER(11)     NOT NULL
    
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
	public long getRegister_num() {
		return register_num;
	}
	public void setRegister_num(long register_num) {
		this.register_num = register_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", type=" + type + ", name=" + name + ", ceo_name=" + ceo_name
				+ ", register_num=" + register_num + ", email=" + email + ", address=" + address + ", detail_address="
				+ detail_address + ", zip_code=" + zip_code + ", register_date=" + register_date + "]";
	}
	
    
    
}
