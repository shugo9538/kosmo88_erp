package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.sale.dto.SalesOrderDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderEstimateListDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderItemDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderListViewDTO;

@Repository
public class SalesOrderDAOImpl implements SalesOrderDAO{
	private static final String STATEMENT = "com.kosmo88.logistics_erp.sale.dao.SalesOrderDAO";
	
	@Autowired
	SqlSession sqlSession;

	// 주문서 목록
	@Override
	public List<SalesOrderListViewDTO> getOrderList() {
		return sqlSession.selectList(STATEMENT+ ".getOrderList");
	}

	// 주문서 삭제(선택삭제)
	@Override
	public int deleteOrder(int request_id) {
		return sqlSession.update(STATEMENT + ".deleteOrder", request_id);
	}

	// 주문서 상세페이지(거래처, 담당자)
	@Override
	public SalesOrderDetailViewDTO getOrderDetail(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getOrderDetail", request_id);
	}

	// 주문서 상세페이지(상품정보)
	@Override
	public SalesOrderDetailViewDTO getOrderDetailItem(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getOrderDetailItem", request_id);
	}

	// 견적서 갯수
	@Override
	public int getEstimateCnt() {
		return sqlSession.selectOne(STATEMENT + ".getEstimateCnt");
	}

	// 견적서 리스트
	@Override
	public List<SalesOrderEstimateListDTO> getEstimateList() {
		return sqlSession.selectList(STATEMENT + ".getEstimateList");
	}

	// 주문서 등록(REQUEST input) 처리
	@Override
	public int insertRequest(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertRequest", map);
	}

	// 주문서(전표) 등록(slip tbl) 처리
	@Override
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

	// 주문 승인 요청
	@Override
	public int requestApproval(int id) {
		return sqlSession.update(STATEMENT + ".requestApproval", id);
	}

	// 견적서 상품 불러오기
	@Override
	public List<SalesOrderItemDTO> getOrderEstimateItemList(int id) {
		return sqlSession.selectList(STATEMENT + ".getOrderEstimateItemList", id);
	}
}
