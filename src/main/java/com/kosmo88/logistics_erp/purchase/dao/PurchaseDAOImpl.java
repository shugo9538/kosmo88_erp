package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.account.vo.ClientVO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO";

	@Autowired
	SqlSession sqlSession;

	// 거래처(구매처) 관리 - 거래처 목록
	@Override
	public List<PurchaseClientDTO> getClientList() {
		List<PurchaseClientDTO> list = sqlSession.selectList(STATEMENT + ".getClientList");
		return list;
	}

	// 거래처 등록 처리
	@Override
	public int registerClient(PurchaseClientDTO cdto) {
		return sqlSession.insert(STATEMENT + ".RegisterClient", cdto);
	}

	// 상품 등록 처리 
	@Override
	public int registerItem(PurchaseItemDTO idto) {
		return sqlSession.insert(STATEMENT + ".RegisterItem", idto);
	}

	// 상세페이지 - 거래처
	@Override
	public PurchaseClientDTO getClientDetail(int id) {
		return sqlSession.selectOne(STATEMENT + ".getClientDetail", id);
	}

	// 상세페이지 - 상품
	@Override
	public List<PurchaseItemDTO> getItemDetail(int id) {
		return sqlSession.selectList(STATEMENT + ".getItemDetail", id);
	}
	
	// 거래처 삭제
	@Override
	public int deleteClient(int id) {
		return sqlSession.update(STATEMENT + ".deleteClient", id);
	}
	
	// 거래처 수정 처리 
	@Override
	public int updateClient(PurchaseClientDTO cdto) {
		return sqlSession.update(STATEMENT + ".updateClient", cdto);
	}

	// 상품 수정 처리
	@Override
	public int updateItem(PurchaseItemDTO idto) {
		return sqlSession.update(STATEMENT + ".updateItem", idto);
	}

    @Override
    public int deleteChoiceClient(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

}
