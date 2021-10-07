package com.kosmo88.logistics_erp.purchase.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.ClientDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertEstimateDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

public interface EstimateService {
	
	// 견적서 관리 - 견적서 목록(구매)
	public List<PurchaseEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res);
	
	// 견적서 등록 화면 - 견적서 거래처 선택
	public void selectClient(HttpServletRequest req, Model model);
	
	// 견적서 등록 화면 - 견적서 담당자 선택 
	public void selectEmployee(HttpServletRequest req, Model model);
	
	// 견적서 등록 처리
	public boolean estimateRegisterAction(PurchaseInsertEstimateDTO dto);
	
	// 견적서 상품 등록 처리
	public boolean itemRegisterAction(PurchaseInsertEstimateDTO dto);
	
	// 견적서 상세페이지
	public void estimateDetail(HttpServletRequest req, Model model);
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	public boolean estimateChoiceDelete(int[] request_id);
	
	// 견적서 삭제(상세페이지에서 단일 삭제)
	public void estimateDelete(HttpServletRequest req, Model model);
	
	// 거래처 상품 불러오기
	public List<PurchaseItemDTO> estimateItemList(HttpServletRequest req, HttpServletResponse res);
	
}
