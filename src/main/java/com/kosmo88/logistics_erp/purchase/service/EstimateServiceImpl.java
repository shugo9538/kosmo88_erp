package com.kosmo88.logistics_erp.purchase.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.EstimateDAO;
import com.kosmo88.logistics_erp.purchase.dao.ClientDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class EstimateServiceImpl implements EstimateService {

    @Autowired
    EstimateDAO estimateDao;
    
    QueryCode state;

    // 견적서 관리 - 견적서 목록(구매)
	@Override
	public List<PurchaseEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<PurchaseEstimateListViewDTO>) estimateDao.getEstimateList();
	}

	// 견적서 관리 - 견적서 삭제(선택삭제)
	@Override
	public boolean estimateChoiceDelete(int[] request_id) {
		state = QueryCode.UPDATE;
		
		for (int i: request_id) {
			if(!state.check(estimateDao.deleteEstimate(i))) {
				return false;
			}
		}
		return true;
	}
	
	// 견적서 등록 화면 - 견적서 거래처 선택
	@Override
	public void selectClient(HttpServletRequest req, Model model) {
		
		// 거래처 갯수
		int cnt = estimateDao.getClientCnt();
		System.out.println("거래처 갯수 : " + cnt);
		
		// 거래처가 있을때
		if (cnt > 0) {
			// 거래처 리스트
			List<PurchaseClientDTO> dtos = estimateDao.getClientList();
			
			model.addAttribute("dtos", dtos);
		}
		model.addAttribute("cnt", cnt);
	}

	// 견적서 등록 화면 - 견적서 담당자 선택 
	@Override
	public void selectEmployee(HttpServletRequest req, Model model) {
		
		// 담당자 갯수
		int cnt = estimateDao.getEmployeeCnt();
		System.out.println("담당자 갯수 : " + cnt);
		
		// 담당자가 있을때
		if (cnt > 0) {
			// 담당자 리스트
			List<PurchaseEmployeeDTO> dtos = estimateDao.getEmployeeList();
			
			model.addAttribute("dtos", dtos);
		}
		model.addAttribute("cnt", cnt);
	}


}
