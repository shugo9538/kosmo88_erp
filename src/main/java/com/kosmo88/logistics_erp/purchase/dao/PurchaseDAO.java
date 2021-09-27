package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

public interface PurchaseDAO {

	// 거래처 갯수 
	public int getClientCnt();
	
    // 거래처(구매처) 관리 - 거래처 목록
	public List<PurchaseClientDTO> getClientList();
	
	// 거래처 등록 처리
	public int RegisterClient(PurchaseClientDTO cdto);
	
	// 상품 등록 처리
	public int RegisterItem(PurchaseItemDTO idto);
	
	// 거래처, 상품 상세페이지
	// public getClientDetail()
	
}