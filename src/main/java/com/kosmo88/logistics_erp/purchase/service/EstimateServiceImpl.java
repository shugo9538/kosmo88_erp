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


}
