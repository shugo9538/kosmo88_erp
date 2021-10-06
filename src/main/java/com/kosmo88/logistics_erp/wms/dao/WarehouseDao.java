package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_warehouse_datailDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;

public interface WarehouseDao {

	void insert(WarehouseDto warehouseDto);
	List<V_warehouse_datailDto> selectList();
	int selectMaxId();
	WarehouseDto selectOne(int id);
	void update(WarehouseDto warehouseDto); 
	void delete(); 
}


@Repository
class WarehouseDaoImpl implements WarehouseDao {

	@Autowired
	SqlSession sqlSession;

//	기존에 Dao에서 하던것 : Service로부터 Dto 등을 넘겨받으면서 실행. DB 와 연결하여 결과를 받아와 저장
//	com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insert
	@Override
	public void insert(WarehouseDto warehouseDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insert", warehouseDto);
	}
	
//	@Override
//	public void insertSection(SectionDto sectionDto) {
//		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insertSection", sectionDto);
//	}

	@Override
	public List<V_warehouse_datailDto> selectList() {
		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectList");
	}

	@Override
	public WarehouseDto selectOne(int id) {
		WarehouseDto warehouseDto = sqlSession.selectOne("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectOne", id);
		System.out.println(warehouseDto);
		return warehouseDto;
	}
	@Override
	public int selectMaxId() {
		return  sqlSession.selectOne("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectMaxId");
	}
	

	@Override
	public void update(WarehouseDto warehouseDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.insert");
	}

	@Override
	public void delete() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.delete");
	}

//	@Override
//	public void selectSection() {
//	}

	



}

