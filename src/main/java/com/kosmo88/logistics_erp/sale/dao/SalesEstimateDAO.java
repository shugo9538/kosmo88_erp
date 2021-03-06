package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

public interface SalesEstimateDAO {

	// 견적서 관리 - 견적서 목록
	public List<SalesEstimateListViewDTO> getEstimateList();
	
	// 견적서 삭제(선택삭제)
	public int deleteEstimate(int request_id);
	
	// 거래처 갯수
	public int getClientCnt();
	
	// 거래처 목록
	public List<SalesClientDTO> getClientList();
	
	// 상품 갯수
	public int getItemCnt();
	
	// 상품 리스트
	public List<SalesItemDTO> getItemList();
	
	// 담당자 갯수
	public int getEmployeeCnt();
	
	// 담당자 불러오기
	public List<SalesEmployeeDTO> getEmployeeList();
	
	// 상품정보 불러오기
	public List<SalesItemDTO> getEstimateItemList();
	
	// 견적서 상세 페이지
	public SalesEstimateDetailViewDTO getEstimateDetail(int request_id);
	
	// 견적서 상세페이지(상품)
	public SalesEstimateDetailViewDTO getEstimateDetailItem(int request_id);
	
	// 견적서 등록(REQUEST input) 처리
	public int insertRequest(Map<String, Object> map);
	
	// 견적서 등록(PRODUCT_GROUP input) 처리
	public int insertProductGroup(Map<String, Object> map);
	
	// 견적서 등록(req_product_list tbl) 처리
	public int insertRPL();
}
