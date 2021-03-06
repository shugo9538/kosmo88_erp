package com.kosmo88.logistics_erp.sale.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertEstimateDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

public interface SalesEstimateService {

	// 견적서 관리 - 견적서 목록(구매)
	public List<SalesEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res);
	
	// 견적서 등록 처리
	public boolean estimateRegisterAction(SalesInsertEstimateDTO dto);
	
	// 견적서 상품 등록 처리
	public boolean itemRegisterAction(SalesInsertEstimateDTO dto);
	
	// 견적서 상세 화면
	public void estimateDetail(HttpServletRequest req, Model model);
	
	// 견적서 삭제
	public void estimateDelete(HttpServletRequest req, Model model);
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	public boolean estimateChoiceDelete(int[] request_id);
	
	// 견적서 등록 화면 - 견적서 거래처 선택
	public void selectClient(HttpServletRequest req, Model model);
	
	// 견적서 등록 화면 - 견적서 담당자 선택 
	public void selectEmployee(HttpServletRequest req, Model model);
	
	// 견적서 등록 화면 - 견적서 상품 선택
	public void selectItem(HttpServletRequest req, Model model);
	
	// 거래처 상품 불러오기
	public List<SalesItemDTO> estimateItemList(HttpServletRequest req, HttpServletResponse res);
	
}
