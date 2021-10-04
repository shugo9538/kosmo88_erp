package com.kosmo88.logistics_erp.sale.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;

public interface SalesEstimateService {

	// 거래처 검색
	public void clientList(HttpServletRequest req, Model model);
	
	// 담당자 검색
	public void employeeList(HttpServletRequest req, Model model);
	
	// 견적서 관리 - 견적서 목록(구매)
	public List<SalesEstimateListViewDTO> estimateList(HttpServletRequest request, HttpServletResponse res);
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	public boolean estimateChoiceDelete(int[] request_id);
	
}
