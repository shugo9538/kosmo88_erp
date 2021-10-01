package com.kosmo88.logistics_erp.sale.dto;

import java.util.Date;

public class SalesInsertClientDTO {

	private int id;						// 거래처코드
	private String type;				// 거래유형 (구매/판매)
	private String name;				// 거래처명
	private String ceo_name;			// 대표자명
	private String register_num;  		// 사업자번호
	private String register_num1;  		// 사업자번호1
	private String register_num2;  		// 사업자번호2
	private String register_num3;  		// 사업자번호3
	private String address;				// 주소
	private String detail_address;		// 상세주소
	private int zip_code;				// 우편번호
	private Date register_date;			// 거래처 등록일
	private String phone;				// 거래처 연락처
	private String phone1;				// 거래처 연락처1
	private String phone2;				// 거래처 연락처2
	private String phone3;				// 거래처 연락처3
	private String email;				// 거래처 이메일
	private String email1;				// 거래처 이메일1
	private String email2;				// 거래처 이메일2
	private String enabled;				// 활성화코드
	
	public SalesInsertClientDTO() {}

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

	public String getRegister_num1() {
		return register_num1;
	}

	public void setRegister_num1(String register_num1) {
		this.register_num1 = register_num1;
	}

	public String getRegister_num2() {
		return register_num2;
	}

	public void setRegister_num2(String register_num2) {
		this.register_num2 = register_num2;
	}

	public String getRegister_num3() {
		return register_num3;
	}

	public void setRegister_num3(String register_num3) {
		this.register_num3 = register_num3;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
}
