package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;

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



}
