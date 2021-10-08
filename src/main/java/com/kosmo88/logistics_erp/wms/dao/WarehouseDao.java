package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_warehouse_detailDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_sectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface WarehouseDao {

	void insert(WarehouseDto warehouseDto);

//	List<V_warehouseDto> selectWarehouse(int warehousId);
	V_warehouseDto selectWarehouse(int warehousId);

	List<V_warehouseDto> selectSimpleList();

	List<V_warehouse_detailDto> selectDetailList();

	int selectMaxId();

	WarehouseDto selectOne(int id);

	void update(WarehouseDto warehouseDto);

	void delete();

	List<V_warehouse_sectionDto> sectionList(int warehouseId);

	List<V_warehouseDto> selectWarehouseList();
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
	public List<V_warehouseDto> selectSimpleList() {
		return sqlSession.selectList(Vars.WAREHOUSE_DAO_PATH + ".selectSimpleList");
//		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.WarehouseDao.selectSimpleList");
	}

	@Override
	public List<V_warehouse_detailDto> selectDetailList() {
		return sqlSession.selectList(Vars.WAREHOUSE_DAO_PATH + ".selectDetailList");
	}

	@Override
//	public List<V_warehouseDto> selectWarehouse(int warehouseId) {
	public V_warehouseDto selectWarehouse(int warehouseId) {
		return sqlSession.selectOne(Vars.WAREHOUSE_DAO_PATH + ".selectWarehouse", warehouseId);
	}

	@Override
	public WarehouseDto selectOne(int id) {
		WarehouseDto warehouseDto = sqlSession.selectOne(Vars.WAREHOUSE_DAO_PATH + ".selectOne", id);
		System.out.println(warehouseDto);
		return warehouseDto;
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.WAREHOUSE_DAO_PATH + ".selectMaxId");
	}

	@Override
	public void update(WarehouseDto warehouseDto) {
		sqlSession.insert(Vars.WAREHOUSE_DAO_PATH + ".insert");
	}

	@Override
	public void delete() {
		sqlSession.insert(Vars.WAREHOUSE_DAO_PATH + ".delete");
	}

	@Override
	public List<V_warehouse_sectionDto> sectionList(int warehouseId) {
		return sqlSession.selectList(Vars.WAREHOUSE_DAO_PATH + ".sectionList", warehouseId);
	}

	@Override
	public List<V_warehouseDto> selectWarehouseList() {
		return sqlSession.selectList(Vars.WAREHOUSE_DAO_PATH + ".selectWarehouseList");
	}

}
