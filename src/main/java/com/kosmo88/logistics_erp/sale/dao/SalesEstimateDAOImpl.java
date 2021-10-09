package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

@Repository
public class SalesEstimateDAOImpl implements SalesEstimateDAO{
	private static final String STATEMENT = "com.kosmo88.logistics_erp.sale.dao.SalesEstimateDAO";
	
	@Autowired
	SqlSession sqlSession;
	
	// 견적서 목록
	@Override
	public List<SalesEstimateListViewDTO> getEstimateList() {
		return sqlSession.selectList(STATEMENT+ ".getEstimateList");
	}

	// 견적서 삭제(선택삭제)
	@Override
	public int deleteEstimate(int request_id) {
		return sqlSession.update(STATEMENT + ".deleteEstimate", request_id);
	}

	// 거래처 갯수
	@Override
	public int getClientCnt() {
		return sqlSession.selectOne(STATEMENT + ".getClientCnt");
	}

	// 거래처 리스트
	@Override
	public List<SalesClientDTO> getClientList() {
		return sqlSession.selectList(STATEMENT + ".getClientList");
	}

	// 상품 갯수
	@Override
	public int getItemCnt() {
		return sqlSession.selectOne(STATEMENT + ".getItemCnt");
	}

	// 상품 리스트
	@Override
	public List<SalesItemDTO> getItemList() {
		return sqlSession.selectList(STATEMENT + ".getItemList");
	}

	// 담당자 갯수
	@Override
	public int getEmployeeCnt() {
		return sqlSession.selectOne(STATEMENT + ".getEmployeeCnt");
	}

	// 담당자 리스트
	@Override
	public List<SalesEmployeeDTO> getEmployeeList() {
		return sqlSession.selectList(STATEMENT + ".getEmployeeList");
	}


	// 견적서 상세페이지
	@Override
	public List<SalesItemDTO> getEstimateItemList() {
		return sqlSession.selectList(STATEMENT + ".getEstimateItemList");
	}
	
	// 견적서 상세페이지(거래처, 담당자 정보)
	@Override
	public SalesEstimateDetailViewDTO getEstimateDetail(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getEstimateDetail", request_id) ;
	}

	// 견적서 상세페이지(상품 정보)
	@Override
	public SalesEstimateDetailViewDTO getEstimateDetailItem(int request_id) {
		return sqlSession.selectOne(STATEMENT + ".getEstimateDetailItem", request_id);
	}
	
	
	// 견적서 등록 처리
	@Override
	public int insertRequest(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertRequest", map);
	}

	// 견적서 등록 그룹 처리
	@Override
	public int insertProductGroup(Map<String, Object> map) {
		return sqlSession.insert(STATEMENT + ".insertProductGroup", map);
	}

	// 견적서 그룹 목록 처리
	@Override
	public int insertRPL() {
		return sqlSession.insert(STATEMENT + ".insertRPL");
	}

	
	

	

	

}
