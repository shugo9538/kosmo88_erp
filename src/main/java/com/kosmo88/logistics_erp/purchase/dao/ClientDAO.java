package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemListViewDTO;

public interface ClientDAO {

	// (구매처)상품 관리 - (구매처)상품 목록
	public List<PurchaseItemListViewDTO> getItemList();
	
	// 사업자번호 중복확인
	public int dupchkRegiNum(String register_num);
	
    // 거래처(구매처) 관리 - 거래처 목록
	public List<PurchaseClientDTO> getClientList();
	
	// 거래처 등록 처리
	public int registerClient(PurchaseInsertClientDTO dto);
	
	// 거래처 상품 등록 처리
	public int registerItem(PurchaseItemDTO dto);
	
	// 상세페이지 - 거래처
	public PurchaseClientDTO getClientDetail(int id);
	
	// 상세페이지 - 상품
	public List<PurchaseItemDTO> getItemDetail(int id);
	
	// 거래처 삭제
	public int deleteClient(int id);
	
	// 거래처 수정 처리
	public int updateClient(PurchaseClientDTO cdto);
	
	// 상품 수정 처리
	public int updateItem(PurchaseItemDTO idto);
	
}