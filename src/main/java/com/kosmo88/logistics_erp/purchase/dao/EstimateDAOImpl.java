package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

@Repository
public class EstimateDAOImpl implements EstimateDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.EstimateDAO";

	@Autowired
	SqlSession sqlSession;

	// 견적서 관리 - 견적서 목록(구매)
	@Override
	public List<PurchaseEstimateListViewDTO> getEstimateList() {
		return sqlSession.selectList(STATEMENT+ ".getEstimateList");
	}

	// 견적서 관리 - 견적서 삭제(선택삭제)
	@Override
	public int deleteEstimate(int request_id) {
		return sqlSession.update(STATEMENT + ".deleteEstimate", request_id);
	}
	
	// 견적서 등록 화면 - 거래처 갯수
	@Override
	public int getClientCnt() {
		return sqlSession.selectOne(STATEMENT + ".getClientCnt");
	}

	// 견적서 등록 화면 - 거래처 리스트
	@Override
	public List<PurchaseClientDTO> getClientList() {
		return sqlSession.selectList(STATEMENT + ".getClientList");
	}
	
	// 견적서 등록 화면 - 담당자 갯수
	@Override
	public int getEmployeeCnt() {
		return sqlSession.selectOne(STATEMENT + ".getEmployeeCnt");
	}
	
	// 견적서 등록 화면 - 담당자 리스트
	@Override
	public List<PurchaseEmployeeDTO> getEmployeeList() {
		return sqlSession.selectList(STATEMENT + ".getEmployeeList");
	}
	
	@Override
	// 거래처 상품 불러오기
	public List<PurchaseItemDTO> getEstimateItemList(int id) {
		return sqlSession.selectList(STATEMENT + ".getEstimateItemList", id);
	}
	
	// 견적서 등록(REQUEST input) 처리
	@Override
	public int insertRequest(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertRequest", map);
	}
	
	// 견적서 등록(PRODUCT_GROUP input) 처리
	@Override
	public int insertProductGroup(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertProductGroup", map);
	}
	
	// 견적서 등록(req_product_list tbl) 처리
	@Override
	public int insertRPL() {
		return sqlSession.insert(STATEMENT + ".insertRPL");
	}
	
	// 견적서 상세페이지(거래처, 담당자 정보)
	@Override
	public PurchaseEstimateDetailViewDTO getEstimateDetail(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getEstimateDetail", request_id);
	}

	// 견적서 상세페이지(상품 정보)
	@Override
	public List<PurchaseEstimateDetailViewDTO> getEstimateDetailItem(int request_id) {
		return sqlSession.selectList(STATEMENT + ".getEstimateDetailItem", request_id);
	}
}
