package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

@Repository
public class ClientDAOImpl implements ClientDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.ClientDAO";

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
	public int registerClient(PurchaseInsertClientDTO dto) {
		return sqlSession.insert(STATEMENT + ".registerClient", dto);
	}

	// 상품 등록 처리 
	@Override
	public int registerItem(PurchaseItemDTO dto) {
		return sqlSession.insert(STATEMENT + ".registerItem", dto);
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
<<<<<<< HEAD

<<<<<<< HEAD:src/main/java/com/kosmo88/logistics_erp/purchase/dao/PurchaseDAOImpl.java
	@Override
	public int deleteChoiceClient(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
=======
    @Override
    public int deleteChoiceClient(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

>>>>>>> main:src/main/java/com/kosmo88/logistics_erp/purchase/dao/ClientDAOImpl.java
=======
>>>>>>> c8cf8506b139343f947f559f0bbb3fe6281b58d4
}
