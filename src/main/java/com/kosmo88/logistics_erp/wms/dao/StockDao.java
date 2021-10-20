package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.StockDto;
import com.kosmo88.logistics_erp.wms.dto.V_section_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_stock_detailDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface StockDao {

	void insertStock(StockDto stockDto);
	void insertStock(Map<String, Object> paramMap);

	void updateStockQuantity(Map<String, Integer> paramMap);

	void deleteStock(int stockId);

	V_stock_detailDto selectOldestStock(int itemId);

	List<V_stockDto> selectStockList(int warehouse_id);


	List<V_section_stockDto> selectStockDetailList(int stockId);

	List<V_stockDto> selectValidStockList(Map<String, Object> paramMap);

	int selectMaxId();
}

@Repository
class StockDaoImpl implements StockDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertStock(StockDto stockDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.StockDao.insertStock", stockDto);
	}

	@Override
	public void insertStock(Map<String, Object> paramMap) {
		sqlSession.insert(Vars.STOCK_DAO_PATH+".insertStock", paramMap);
	}


	@Override
	public List<V_stockDto> selectStockList(int warehouse_id){
		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.StockDao.selectStockList", warehouse_id);
	}
	
	@Override
	public List<V_section_stockDto> selectStockDetailList(int stockId) {
		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.StockDao.selectStockDetailList", stockId);
	}



	@Override
	public List<V_stockDto> selectValidStockList(Map<String, Object> paramMap) {
		return sqlSession.selectList(Vars.STOCK_DAO_PATH+".selectValidStockList", paramMap);
	}
	
	@Override
	public V_stock_detailDto selectOldestStock(int itemId) {
		return sqlSession.selectOne(Vars.STOCK_DAO_PATH+".selectOldestStock", itemId);
	}
	
	@Override
	public void updateStockQuantity(Map<String, Integer> paramMap) {
		sqlSession.update(Vars.STOCK_DAO_PATH+".updateStockQuantity", paramMap);
	}
	
	@Override
	public void deleteStock(int stockId) {
		sqlSession.delete(Vars.STOCK_DAO_PATH+".deleteStock", stockId);
	}


	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.STOCK_DAO_PATH + ".selectMaxId");
	}


	
}
