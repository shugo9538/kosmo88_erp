package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO";

	@Autowired
	SqlSession sqlSession;

	// 거래처 갯수 가져오기
	@Override
	public int getClientCnt() {
		return sqlSession.selectOne(STATEMENT + ".getClientCnt");
	}

	// 거래처(구매처) 관리 - 거래처 목록
	@Override
	public List<PurchaseClientDTO> getClientList() {
		PurchaseDAO dao = sqlSession.getMapper(PurchaseDAO.class);
		return dao.getClientList();
	}

	// 거래처 등록 처리
	@Override
	public int RegisterClient(PurchaseClientDTO cdto) {
		return sqlSession.insert(STATEMENT + ".RegisterClient", cdto);
	}

	// 상품 등록 처리
	@Override
	public int RegisterItem(PurchaseItemDTO idto) {
		return sqlSession.insert(STATEMENT + ".RegisterItem", idto);
	}

}
