package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

public interface PurchaseDAO {

/*
	// 거래처 갯수 
	public int getClientCnt();
*/	
    // 거래처(구매처) 관리 - 거래처 목록
	public List<PurchaseClientDTO> getClientList();
	
	// 거래처 등록 처리
	public int registerClient(PurchaseClientDTO cdto);
	
	// 상품 등록 처리
	public int registerItem(PurchaseItemDTO idto);
	
	// 상세페이지 - 거래처
	public PurchaseClientDTO getClientDetail(int id);
	
	// 상세페이지 - 상품
	public List<PurchaseItemDTO> getItemDetail(int id);
	
	// 거래처 삭제 처리
	public int deleteChoiceClient(int id);
	
	// 거래처 수정 처리
	public int updateClient(PurchaseClientDTO cdto);
	
	// 상품 수정 처리
	public int updateItem(PurchaseItemDTO idto);
	
	
}