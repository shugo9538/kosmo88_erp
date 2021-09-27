package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesDTO;

@Repository
public class SalesDAOImpl implements SalesDAO{
	
	@Autowired
	SqlSession sqlSession;
	

	// 거래처 목록 갯수
	@Override
	public int getClientCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.sale.dao.SalesDAO.getClientCnt");
	}

	// 거래처 목록 조회
	@Override
	public List<SalesClientDTO> getClientList(Map<String, Object> map) {
		return sqlSession.selectList("com.kosmo88.logistics_erp.sale.dao.SalesDAO.getClientList", map);
	}
	
	// 거래처 상세 정보
	@Override
	public SalesClientDTO getClientDetail(int id) {
		SalesClientDTO dto = sqlSession.selectOne("com.kosmo88.logistics_erp.sale.dao.SalesDAO.getClientDetail", id);
		return dto;
	}
	
	// 거래처 등록
	@Override
	public int registerClient(SalesClientDTO dto) {
		return sqlSession.insert("com.kosmo88.logistics_erp.sale.dao.SalesDAO.registerClient", dto);
	}

	// 거래처 수정
	@Override
	public int updateClient(SalesClientDTO dto) {
		int updateCnt = sqlSession.update("com.kosmo88.logistics_erp.sale.dao.SalesDAO.updateClient", dto);
		return updateCnt;
	}

	@Override
	public int deleteClient(int id) {
		int deleteCnt = sqlSession.delete("com.kosmo88.logistics_erp.sale.dao.SalesDAO.deleteClient", id);
		return deleteCnt;
	}

	



}
