package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.StockDto;
import com.kosmo88.logistics_erp.wms.dto.V_Stock_SectionDto;

public interface StockDao {

	void insert(StockDto stockDto);
	void select();
	List<V_Stock_SectionDto> selectList(int warehouseId);
	int selectMaxId();
	void update(); 
	void delete();
	}


@Repository
class StockDaoImpl implements StockDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(StockDto stockDto) {
	sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.StockDao.insert", stockDto);
	}

	@Override
	public void select() {
	sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.StockDao.select");
	}

	@Override
	public List<V_Stock_SectionDto> selectList(int warehouseId) {
	return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.StockDao.selectList", warehouseId);
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
