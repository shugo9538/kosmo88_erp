package com.kosmo88.logistics_erp.sale.service;

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

import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderItemDTO;
import com.kosmo88.logistics_erp.sale.dao.SalesOrderDAO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertOrderDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderEstimateListDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderItemDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderListViewDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{

	@Autowired
	SalesOrderDAO orderDao;
	
	QueryCode state;

	// 주문서 목록
	@Override
	public List<SalesOrderListViewDTO> orderList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<SalesOrderListViewDTO>) orderDao.getOrderList();
	}

	// 주문서 등록 처리
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean orderRegisterAction(SalesInsertOrderDTO dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean insert = false;
		state = QueryCode.INSERT;
		
		map.put("state", "RX_ORDER");
		map.put("employee_id", dto.getEmployee_id());
		map.put("client_id", dto.getClient_id());
		map.put("end_date", dto.getEnd_date());
		map.put("type", "WITHDRAW");
		map.put("department_id", dto.getDepartment_id());
		System.out.println("담당자 id : " + dto.getEmployee_id());
		System.out.println("거래처 id : " + dto.getClient_id());
		System.out.println("납기요청일자: " + dto.getEnd_date());
		System.out.println("담당자 부서 : " + dto.getDepartment_id());
		
		// request tbl 입력
		insert = state.check(orderDao.insertRequest(map));
		System.out.println("request tbl 입력 : " + insert);
		
		// slip tbl 입력
		insert = state.check(orderDao.insertSlip(map));
		System.out.println("slip tbl 입력 : " + insert);
		
		return insert;
	}

	// 주문서 상품 등록 처리
	@Override
	public boolean itemRegisterAction(SalesOrderItemDTO dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean insert = false;
		state = QueryCode.INSERT;
		
		map.put("quantity", dto.getItem_quantity());
		map.put("item_id", dto.getItem_id());
		map.put("sales_price", dto.getItem_sales_price());
		System.out.println("상품 수량 : " + dto.getItem_quantity());
		System.out.println("상품 코드 : " + dto.getItem_id());
		System.out.println("판매가격 : " + dto.getItem_sales_price());
		
		// product_group tbl 입력
		insert = state.check(orderDao.insertProductGroup(map));
		System.out.println("product_group tbl 입력 : " + insert);
		
		// req_product_list tbl 입력
		insert = state.check(orderDao.insertRPL());
		System.out.println("req_product_list tbl 입력 : " + insert);
		
		return insert;
	}

	// 주문서 상세
	@Override
	public void orderDetail(HttpServletRequest req, Model model) {
		// 화면에서 값을 받아온다.
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		SalesOrderDetailViewDTO dto = orderDao.getOrderDetail(request_id);
		
		// 주문서 상세페이지(상품 정보)
		SalesOrderDetailViewDTO idto = orderDao.getOrderDetailItem(request_id);
		System.out.println(idto.getItem_name());
		System.out.println(idto.getItem_category());
		System.out.println(idto.getItem_quantity());
		System.out.println(idto.getItem_sales_price());
		
		model.addAttribute("dto", dto);
		model.addAttribute("idto", idto);
		
	}

	// 주문서 삭제(선택삭제)
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

	// 주문서 삭제(상세페이지에서 단일 삭제)
	@Override
	public void orderDelete(HttpServletRequest req, Model model) {
		// 화면에서 값을 가져온다.
		int id = Integer.parseInt(req.getParameter("request_id"));
		
		state = QueryCode.UPDATE;
		boolean update = false;
		
		// 주문서 삭제 처리
		update = state.check(orderDao.deleteOrder(id));
		System.out.println("주문서 삭제 처리 : " + update);
		
		model.addAttribute("update", update);
		
	}

	// 견적서 선택
	@Override
	public void selectEstimate(HttpServletRequest req, Model model) {
		
		// 견적서 갯수
		int cnt = orderDao.getEstimateCnt();
		System.out.println("견적서 갯수 : " + cnt);
		
		// 주문서 등록 화면 - 견적서가 있을때
		if (cnt > 0) {
			// 견적서 리스트
			List<SalesOrderEstimateListDTO> dtos = orderDao.getEstimateList();
			
			model.addAttribute("dtos", dtos);
		}
		model.addAttribute("cnt", cnt);
		
	}

	// 견적서 상품 불러오기
	@Override
	public List<SalesOrderItemDTO> orderEstimateItemList(HttpServletRequest req, HttpServletResponse res) {
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		
		return (ArrayList<SalesOrderItemDTO>) orderDao.getOrderEstimateItemList(request_id);
	}

	// 주문 승인 요청
	@Override
	public boolean orderApproval(int id) {
		boolean update = false;
		state = QueryCode.UPDATE;
		
		return state.check(orderDao.requestApproval(id));
	}
	
	
}
