package com.kosmo88.logistics_erp.account.dto;

public class DepositWithdrawalHistoryDTO {
	
	
	private String name; //통장이름
	private String transaction_date;// 거래일자, 거래시간
	// 거래시간
	private String account_number;// 계좌번호
	private String abs;// 적요 abstract 예약어로 앞 세글자로 변경 abs
	private String type;// 입금
	private String balance;// 잔액
	private String bank;// 은행
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
}
