package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

public interface SalesClientDAO {

	// 거래처 관리 - 거래처 목록
	public List<SalesClientDTO> getClientList();
	
	// 거래처 등록 처리
	public int registerClient(SalesInsertClientDTO dto);
	
	// 상품 등록 처리
	public int registerItem(SalesItemDTO dto);
	
	// 상세페이지 - 거래처
	public SalesClientDTO getClientDetail(int id);
	
	// 거래처 삭제
	public int deleteClient(int id);
	
	// 거래처 수정 처리
	public int updateClient(SalesClientDTO dto);
}
