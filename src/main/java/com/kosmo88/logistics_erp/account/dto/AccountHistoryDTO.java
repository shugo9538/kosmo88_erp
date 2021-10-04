package com.kosmo88.logistics_erp.account.dto;

public class AccountHistoryDTO {
	
	// 통장 입출금 
	
	private String account_number;// 계좌번호
	private String type;// 입출금 유형
	private int balance;// 입금
	private String abs;// 적요 abstract 예약어로 앞 세글자로 변경 abs
	private String transaction_date;// 거래일자
	
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	
}
