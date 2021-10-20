package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

@Repository
public class SalesClientDAOImpl implements SalesClientDAO{
	private static final String STATEMENT = "com.kosmo88.logistics_erp.sale.dao.SalesClientDAO";
	
	@Autowired
	SqlSession sqlSession;
	
	// 거래처 목록
	@Override
	public List<SalesClientDTO> getClientList() {
		List<SalesClientDTO> list = sqlSession.selectList(STATEMENT + ".getClientList");
		return list;
	}

	// 거래처 등록
	@Override
	public int registerClient(SalesInsertClientDTO dto) {
		return sqlSession.insert(STATEMENT + ".registerClient", dto);
	}

	@Override
	public int registerItem(SalesItemDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 거래처 상세페이지
	@Override
	public SalesClientDTO getClientDetail(int id) {
		return sqlSession.selectOne(STATEMENT + ".getClientDetail", id);
	}

	// 거래처 삭제
	@Override
	public int deleteClient(int id) {
		return sqlSession.update(STATEMENT + ".deleteClient", id);
	}

	// 거래처 수정
	@Override
	public int updateClient(SalesClientDTO dto) {
		return sqlSession.update(STATEMENT + ".updateClient", dto);
	}

	

}
