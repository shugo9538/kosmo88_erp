package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.PurchaseAndSaleDto;
import com.kosmo88.logistics_erp.wms.dto.SalesDetailDto;

public interface ElasticDao {

	List<PurchaseAndSaleDto> selectPurchaseAndSaleList();

	List<SalesDetailDto> selectSalesDetailList(); 

}

@Repository
class EsEtlDaoImpl implements ElasticDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<PurchaseAndSaleDto> selectPurchaseAndSaleList() {
		return sqlSession.selectList("selectPurchaseAndSaleList");
	}
	
	@Override
	public List<SalesDetailDto> selectSalesDetailList() {
		return sqlSession.selectList("selectSalesDetailList");
	}
	
	
}
