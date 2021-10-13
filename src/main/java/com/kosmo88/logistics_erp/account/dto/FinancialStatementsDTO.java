package com.kosmo88.logistics_erp.account.dto;

import org.apache.ibatis.type.Alias;

@Alias("FinancialStatementsDTO")
public class FinancialStatementsDTO {
	
		//당좌자산
		private long cash_asets;// 현금및 현금성자산(보통예금포함)	
		private long accounts_receivable;//매출채권(외상매출금)
		private long vatPayment;//부가세대급금
		//재고자산
		private long inventory_assets;//상품
		//부채
		private long purchase_receivable; //매입채권(외상매입금)
		private long vatDeposit;//부가세예수금
		private long capital; //자본금
		
		
		public long getCash_asets() {
			return cash_asets;
		}
		public void setCash_asets(long cash_asets) {
			this.cash_asets = cash_asets;
		}
		public long getAccounts_receivable() {
			return accounts_receivable;
		}
		public void setAccounts_receivable(long accounts_receivable) {
			this.accounts_receivable = accounts_receivable;
		}
		public long getVatPayment() {
			return vatPayment;
		}
		public void setVatPayment(long vatPayment) {
			this.vatPayment = vatPayment;
		}
		public long getInventory_assets() {
			return inventory_assets;
		}
		public void setInventory_assets(long inventory_assets) {
			this.inventory_assets = inventory_assets;
		}
		public long getPurchase_receivable() {
			return purchase_receivable;
		}
		public void setPurchase_receivable(long purchase_receivable) {
			this.purchase_receivable = purchase_receivable;
		}
		public long getVatDeposit() {
			return vatDeposit;
		}
		public void setVatDeposit(long vatDeposit) {
			this.vatDeposit = vatDeposit;
		}
		public long getCapital() {
			return capital;
		}
		public void setCapital(long capital) {
			this.capital = capital;
		}

}
