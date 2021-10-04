package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;

public interface SalesEstimateDAO {

	// 거래처 검색
	public List<SalesClientDTO> choiseClient();
	
	// 담당자 검색
	public List<SalesEmployeeDTO> choiseEmployee();
	
	// 견적서 관리 - 견적서 목록(구매)
	public List<SalesEstimateListViewDTO> getEstimateList();
}
