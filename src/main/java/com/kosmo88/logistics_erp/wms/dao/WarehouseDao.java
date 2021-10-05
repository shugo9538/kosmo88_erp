package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_warehouse_detailDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_simpleDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface WarehouseDao {

	void insert(WarehouseDto warehouseDto);
	List<V_warehouse_simpleDto> selectSimpleList();
	List<V_warehouse_detailDto> selectDetailList();
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
		sqlSession.insert(Vars.WAREHOUSE_DAO_PATH + ".insert", warehouseDto);
	}
//	@Override
//	public void insertSection(SectionDto sectionDto) {
//		sqlSession.insert(Vars.WAREHOUSE_DAO_PATH + ".insertSection", sectionDto);
//	}

	@Override
	public List<V_warehouse_simpleDto> selectSimpleList() {
		return sqlSession.selectList(Vars.WAREHOUSE_DAO_PATH + ".selectSimpleList");
//		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectSimpleList");
	}

	@Override
	public List<V_warehouse_detailDto> selectDetailList() {
		return sqlSession.selectList(Vars.WAREHOUSE_DAO_PATH + ".selectDetailList");
	}
	
	@Override
	public WarehouseDto selectOne(int id) {
		WarehouseDto warehouseDto = sqlSession.selectOne(Vars.WAREHOUSE_DAO_PATH + ".selectOne", id);
		System.out.println(warehouseDto);
		return warehouseDto;
	}
	@Override
	public int selectMaxId() {
		return  sqlSession.selectOne(Vars.WAREHOUSE_DAO_PATH + ".selectMaxId");
	}
	

	@Override
	public void update(WarehouseDto warehouseDto) {
		sqlSession.insert(Vars.WAREHOUSE_DAO_PATH + ".insert");
	}

	@Override
	public void delete() {
		sqlSession.insert(Vars.WAREHOUSE_DAO_PATH + ".delete");
	}

//	@Override
//	public void selectSection() {
//	}

	



}

