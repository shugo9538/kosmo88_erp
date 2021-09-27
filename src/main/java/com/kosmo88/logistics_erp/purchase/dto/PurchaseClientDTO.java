package com.kosmo88.logistics_erp.purchase.dto;

import java.util.Date;

// 거래처 DTO
public class PurchaseClientDTO {
	
	private int id;					// 거래처코드
	private int type;				// 거래유형 (구매/판매)
	private String name;			// 거래처명
	private String ceo_name;		// 대표자명
	private long register_num;  	// 사업자번호
	private String address;			// 주소
	private String detail_address;	// 상세주소
	private int zip_code;			// 우편번호
	private Date register_date;		// 거래처 등록일
	private int phone;				// 거래처 연락처
	private String email;			// 거래처 이메일
	
	public PurchaseClientDTO() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}