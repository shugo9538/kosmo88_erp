package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.StockDto;
import com.kosmo88.logistics_erp.wms.dto.V_section_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_stock_detailDto;

public interface StockDao {

	void insertStock(StockDto stockDto);

	List<V_stockDto> selectStockList(int warehouse_id);


	List<V_section_stockDto> selectStockDetailList(int stockId);

	void select();

	int selectMaxId();

	void update();

	void delete();
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
	public void select() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.StockDao.select");
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
	public int selectMaxId() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.wms.dao.StockDao.selectMaxId");
	}

	@Override
	public void update() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.StockDao.insert");
	}

	@Override
	public void delete() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.StockDao.insert");
	}

}
