package com.kosmo88.logistics_erp.purchase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.EstimateDAO;
import com.kosmo88.logistics_erp.purchase.dao.ClientDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertEstimateDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class EstimateServiceImpl implements EstimateService {

    @Autowired
    EstimateDAO estimateDao;
    
    @Autowired
    private EstimateService self;
    
    
    QueryCode state;
    
    // Transactional 사용
    public void estimateRegisterAction(List<PurchaseInsertEstimateDTO> dtos) {
    	dtos.forEach(dto -> self.estimateRegisterAction(dto));
    }

    // 견적서 관리 - 견적서 목록(구매)
	@Override
	public List<PurchaseEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<PurchaseEstimateListViewDTO>) estimateDao.getEstimateList();
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

	// 견적서 등록 처리
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean estimateRegisterAction(PurchaseInsertEstimateDTO dto) {
		
		state = QueryCode.INSERT;
		
		// 1. REQUEST tbl 입력
		estimateDao.insertRequest(dto);
		
		
		// 2. PRODUCT_GROUP tbl 입력
		
		
		
		// 3. REQ_PRODUCT_LIST tbl 입력
		
		
		
		return true;
	}

	// 견적서 상세페이지
	@Override
	public void estimateDetail(HttpServletRequest req, Model model) {
		
		// 화면에서 값을 받아온다.
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		
		// 견적서 상세페이지(거래처, 담당자 정보)
		PurchaseEstimateDetailViewDTO dto = estimateDao.getEstimateDetail(request_id);
		
		// 견적서 상세페이지(상품 정보)
		List<PurchaseEstimateDetailViewDTO> idtos = estimateDao.getEstimateDetailItem(request_id);
		
		model.addAttribute("dto", dto);
		model.addAttribute("idtos", idtos);
	}
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	@Override
	public boolean estimateChoiceDelete(int[] request_id) {
		state = QueryCode.UPDATE;
		
		for (int id: request_id) {
			if(!state.check(estimateDao.deleteEstimate(id))) {
				return false;
			}
		}
		return true;
	}
	
	// 견적서 삭제(상세페이지에서 단일 삭제)
	@Override
	public void estimateDelete(HttpServletRequest req, Model model) {

		// 화면에서 값을 가져온다.
		int id = Integer.parseInt(req.getParameter("request_id"));
		
		state = QueryCode.UPDATE;
		boolean update = false;
		
		// 거래처 삭제 처리
		update = state.check(estimateDao.deleteEstimate(id));
		System.out.println("견적서 삭제 처리 : " + update);
		
		model.addAttribute("update", update);
	}	


}
