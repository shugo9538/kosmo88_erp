package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.RackDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;

@Repository
public class WarehouseDaoImpl implements WarehouseDao {

	@Autowired
	SqlSession sqlSession;

//	기존에 Dao에서 하던것 : Service로부터 Dto 등을 넘겨받으면서 실행. DB 와 연결하여 결과를 받아와 저장
//	com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insert
	@Override
	public void insert(WarehouseDto warehouseDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insert", warehouseDto);
	}
	
	@Override
	public void insertRack(RackDto rackDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insertRack", rackDto);
	}

	@Override
	public List<WarehouseDto> select() {
		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.select");
	}

	@Override
	public WarehouseDto selectOne() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectOne");
	}

	@Override
	public void selectRack() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao");
	}

	@Override
	public void update(WarehouseDto warehouseDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insert");
	}

	@Override
	public void delete() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.delete");
	}

	@Override
	public int selectMaxId() {
		return  sqlSession.selectOne("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectMaxId");
	}



}
