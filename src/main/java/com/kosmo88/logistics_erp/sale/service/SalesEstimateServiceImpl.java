package com.kosmo88.logistics_erp.sale.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.dao.SalesEstimateDAO;
import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertEstimateDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class SalesEstimateServiceImpl implements SalesEstimateService{

	@Autowired
	SalesEstimateDAO estimateDao;
	
	QueryCode state;

	@Override
	public List<SalesEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<SalesEstimateListViewDTO>) estimateDao.getEstimateList();
	}

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

	@Override
	public void selectClient(HttpServletRequest req, Model model) {
		// 거래처 갯수
		int cnt = estimateDao.getClientCnt();
		System.out.println("거래처 갯수 : " + cnt);
		
		// 거래처가 있을때
		if (cnt > 0) {
			// 거래처 리스트
			List<SalesClientDTO> dtos = estimateDao.getClientList();
			
			model.addAttribute("dtos", dtos);
		}
		model.addAttribute("cnt", cnt);
		
	}

	@Override
	public void selectEmployee(HttpServletRequest req, Model model) {
		// 담당자 갯수
		int cnt = estimateDao.getEmployeeCnt();
		System.out.println("담당자 갯수 : " + cnt);
		
		// 담당자가 있을때
		if (cnt > 0) {
			// 담당자 리스트
			List<SalesEmployeeDTO> dtos = estimateDao.getEmployeeList();
			
			model.addAttribute("dtos", dtos);
		}
		model.addAttribute("cnt", cnt);
		
	}

	// 견적서 상품 등록
	@Override
	public void selectItem(HttpServletRequest req, Model model) {

		// 상품갯수
		int cnt = estimateDao.getItemCnt();
		System.out.println("상품 갯수 : " + cnt);
		
		if(cnt > 0) {
			List<SalesItemDTO> dtos = estimateDao.getItemList();
			
			model.addAttribute("dtos", dtos);
		}
		
		model.addAttribute("cnt", cnt);
	}

	// 견적서 상세 페이지
	@Override
	public void estimateDetail(HttpServletRequest req, Model model) {
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		
		SalesEstimateListViewDTO dto = estimateDao.getEstimateDetail(request_id);
		
		// 견적서 상세페이지(상품정보)
		// List<SalesEstimateDetailViewDTO> idto = estimateDao.getEstimateDetail(request_id);
		
		model.addAttribute("dto", dto);
		// model.addAttribute("idto", idto); 
	}

	// 견적서 등록 처리
	@Override
	public boolean estimateRegisterAction(SalesInsertEstimateDTO dto) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		state = QueryCode.INSERT;
		
		map.put("state", "RX_ESTIMATE");
		map.put("employee_id", dto.getEmployee_id());
		map.put("client_id", dto.getClient_id());
		
		// EQUEST tbl 입력
		return state.check(estimateDao.insertRequest(map));
	}

	// 아이템 등록 처리
	@Override
	public boolean itemRegisterAction(SalesInsertEstimateDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	// 상품 불러오기
	@Override
	public List<SalesItemDTO> estimateItemList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<SalesItemDTO>) estimateDao.getEstimateItemList();
	}
	
}
