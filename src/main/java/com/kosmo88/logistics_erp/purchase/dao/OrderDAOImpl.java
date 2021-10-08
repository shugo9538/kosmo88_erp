package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertOrderDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderEstimateListDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.OrderDAO";

	@Autowired
	SqlSession sqlSession;

	// 구매 관리 - 주문서 목록(구매)
	@Override
	public List<PurchaseOrderListViewDTO> getOrderList() {
		return sqlSession.selectList(STATEMENT+ ".getOrderList");
	}

	// 구매 관리 - 주문서 삭제(선택삭제)
	@Override
	public int deleteOrder(int request_id) {
		return sqlSession.update(STATEMENT + ".deleteOrder", request_id);
	}
	
	// 주문서 상세페이지(거래처, 담당자 정보)
	@Override
	public PurchaseOrderDetailViewDTO getOrderDetail(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getOrderDetail", request_id);
	}

	// 주문서 상세페이지(상품 정보)
	@Override
	public List<PurchaseOrderDetailViewDTO> getOrderDetailItem(int request_id) {
		return sqlSession.selectList(STATEMENT + ".getOrderDetailItem", request_id);
	}

	// 주문서 등록 화면 - 견적서 갯수
	@Override
	public int getEstimateCnt() {
		return sqlSession.selectOne(STATEMENT + ".getEstimateCnt");
	}

	// 주문서 등록 화면 - 견적서 리스트
	@Override
	public List<PurchaseOrderEstimateListDTO> getEstimateList() {
		return sqlSession.selectList(STATEMENT + ".getEstimateList");
	}

	// 견적서 상품 불러오기
	@Override
	public List<PurchaseOrderItemDTO> getOrderEstimateItemList(int id) {
		return sqlSession.selectList(STATEMENT + ".getOrderEstimateItemList", id);
	}
	
	// 주문서 등록(REQUEST input) 처리
	@Override
	public int insertRequest(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertRequest", map);
	}
	
	// 주문서(전표) 등록(slip tbl) 처리
	public int insertSlip(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertSlip", map);
	}
	
	// 주문서 등록(PRODUCT_GROUP tbl) 처리
	@Override
	public int insertProductGroup(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertProductGroup", map);
	}
	
	// 주문서 등록(REQ_PRODUCT_LIST) 처리
	@Override
	public int insertRPL() {
		return sqlSession.insert(STATEMENT + ".insertRPL");
	}
	
	
	

}
