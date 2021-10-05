package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.OrderDAO";

	@Autowired
	SqlSession sqlSession;

	// 구매 관리 - 발주서 목록(구매)
	@Override
	public List<PurchaseOrderListViewDTO> getOrderList() {
		return sqlSession.selectList(STATEMENT+ ".getOrderList");
	}

	// 구매 관리 - 발주서 삭제(선택삭제)
	@Override
	public int deleteOrder(int request_id) {
		return sqlSession.update(STATEMENT + ".deleteOrder", request_id);
	}


	
	
	
	// 발주서 상세페이지(거래처, 담당자 정보)
	@Override
	public PurchaseOrderDetailViewDTO getOrderDetail(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getOrderDetail", request_id);
	}

	// 발주서 상세페이지(상품 정보)
	@Override
	public List<PurchaseOrderDetailViewDTO> getOrderDetailItem(int request_id) {
		return sqlSession.selectList(STATEMENT + ".getOrderDetailItem", request_id);
	}
	
	
	
	
	
	
	

}
