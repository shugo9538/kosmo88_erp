package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {
	private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.OrderDAO";

	@Autowired
	SqlSession sqlSession;

	// 견적서 관리 - 견적서 목록(구매)
	@Override
	public List<PurchaseOrderListViewDTO> getOrderList() {
		return sqlSession.selectList(STATEMENT+ ".getOrderList");
	}

	// 견적서 관리 - 견적서 삭제(선택삭제)
	@Override
	public int deleteOrder(int request_id) {
		return sqlSession.update(STATEMENT + ".deleteOrder", request_id);
	}

}
