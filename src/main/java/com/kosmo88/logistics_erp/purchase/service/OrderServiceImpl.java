package com.kosmo88.logistics_erp.purchase.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.ClientDAO;
import com.kosmo88.logistics_erp.purchase.dao.OrderDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertEstimateViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDao;
    
    QueryCode state;
    
    // 구매 관리 - 발주서 목록
	@Override
	public List<PurchaseOrderListViewDTO> orderList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<PurchaseOrderListViewDTO>) orderDao.getOrderList();
	}
/*	
	
	// 발주서 등록 화면 - 발주서 거래처 선택
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

	// 발주서 등록 화면 - 발주서 담당자 선택 
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

	// 발주서 등록 처리
	@Override
	public boolean estimateRegisterAction(PurchaseInsertEstimateViewDTO dto) {
		state = QueryCode.INSERT;
		return state.check(estimateDao.insertEstimate(dto));
	}
*/
	
	// 발주서 상세페이지
	@Override
	public void orderDetail(HttpServletRequest req, Model model) {
		
		// 화면에서 값을 받아온다.
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		
		// 발주서 상세페이지(거래처, 담당자 정보)
		PurchaseOrderDetailViewDTO dto = orderDao.getOrderDetail(request_id);
		
		// 발주서 상세페이지(상품 정보)
		List<PurchaseOrderDetailViewDTO> idtos = orderDao.getOrderDetailItem(request_id);
		
		model.addAttribute("dto", dto);
		model.addAttribute("idtos", idtos);
	}
	
	// 구매 관리 - 발주서 삭제(선택삭제)
	@Override
	public boolean orderChoiceDelete(int[] request_id) {
		state = QueryCode.UPDATE;
		
		for (int id: request_id) {
			if(!state.check(orderDao.deleteOrder(id))) {
				return false;
			}
		}
		return true;
	}

	// 발주서 삭제(상세페이지에서 단일 삭제)
	@Override
	public void orderDelete(HttpServletRequest req, Model model) {

		// 화면에서 값을 가져온다.
		int id = Integer.parseInt(req.getParameter("request_id"));
		
		state = QueryCode.UPDATE;
		boolean update = false;
		
		// 발주서 삭제 처리
		update = state.check(orderDao.deleteOrder(id));
		System.out.println("발주서 삭제 처리 : " + update);
		
		model.addAttribute("update", update);
	}	
	
}
