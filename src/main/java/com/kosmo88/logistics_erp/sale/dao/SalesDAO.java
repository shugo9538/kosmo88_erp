package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;
import java.util.Map;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesDTO;

public interface SalesDAO {

	// 거래처 목록 갯수
	public int getClientCnt();
	
	// 거래처 목록
	public List<SalesClientDTO> getClientList();
	
	// 거래처 상세 정보
	public SalesClientDTO getClientDetail(int id);
	
	// 거래처 등록
	public int registerClient(SalesClientDTO dto);
	
	// 거래처 수정
	public int updateClient(SalesClientDTO dto);
	
	// 거래처 삭제
	public int deleteClient(int id);
}
