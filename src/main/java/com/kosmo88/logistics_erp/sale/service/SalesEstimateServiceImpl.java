package com.kosmo88.logistics_erp.sale.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dao.SalesEstimateDAO;
import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class SalesEstimateServiceImpl implements SalesEstimateService{

	@Autowired
	SalesEstimateDAO estimateDao;
	
	
	QueryCode state;
	
	// 거래처 검색
	@Override
	public void clientList(HttpServletRequest req, Model model) {

		List<SalesClientDTO> dto = estimateDao.choiseClient();
		
		model.addAttribute("dto", dto);
		
	}
	
	// 사원 검색
	@Override
	public void employeeList(HttpServletRequest req, Model model) {

		List<SalesEmployeeDTO> dto = estimateDao.choiseEmployee();
		
		model.addAttribute("dto", dto);
	}
	
	// 견적서 관리 - 견적서 목록(구매)
	@Override
	public List<SalesEstimateListViewDTO> estimateList(HttpServletRequest request, HttpServletResponse res) {
		return (ArrayList<SalesEstimateListViewDTO>) estimateDao.getEstimateList();
	}

	// 견적서 선택 삭제
	@Override
	public boolean estimateChoiceDelete(int[] request_id) {
		// TODO Auto-generated method stub
		return false;
	}

	// 견적서 상세페이지
	@Override
	public void estimateDetail(HttpServletRequest req, Model model) {
		
		int id = Integer.parseInt(req.getParameter("request_id"));
		
	}

	

	

	
}
