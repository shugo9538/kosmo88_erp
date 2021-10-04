package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

public interface SalesEstimateDAO {

	// 견적서 관리 - 견적서 목록(구매)
	public List<SalesEstimateListViewDTO> getEstimateList();
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	public int deleteEstimate(int request_id);
	
	// 견적서 등록 화면 - 거래처 갯수
	public int getClientCnt();
	
	// 견적서 등록 화면 - 거래처 리스트
	public List<SalesClientDTO> getClientList();
	
	// 견적서 등록 화면 - 상품 갯수
	public int getItemCnt();
	
	// 견적서 등록 화면 - 상품 리스트
	public List<SalesItemDTO> getItemList();
	
	// 견적서 등록 화면 - 담당자 갯수
	public int getEmployeeCnt();
	
	// 견적서 등록 화면 - 담당자 리스트
	public List<SalesEmployeeDTO> getEmployeeList();
	
	// 견적서 상세 페이지
<<<<<<< HEAD
	public SalesEstimateDetailViewDTO getEstimateDetail(int request_id);
	
	public List<SalesEstimateDetailViewDTO> getEstimateDetailItem(int request_id);
=======
	public SalesEstimateListViewDTO getEstimateDetail(int request_id);
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
	
	
}
