package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEmployeeDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;

@Repository
public class SalesEstimateDAOImpl implements SalesEstimateDAO{
	private static final String STATEMENT = "com.kosmo88.logistics_erp.sale.dao.SalesEstimateDAO";
	
	@Autowired
	SqlSession sqlSession;
	
	// 거래처 검색
	@Override
	public List<SalesClientDTO> choiseClient() {
		
		return sqlSession.selectList(STATEMENT + ".choiseClient");
	}
	
	// 담당자 검색
	@Override
	public List<SalesEmployeeDTO> choiseEmployee() {
		
		return sqlSession.selectList(STATEMENT + ".chiseEmployee");
	}
	
	// 견적서 목록
	@Override
	public List<SalesEstimateListViewDTO> getEstimateList() {
		return sqlSession.selectList(STATEMENT + ".getEstimateList");
	}

	

	

}
