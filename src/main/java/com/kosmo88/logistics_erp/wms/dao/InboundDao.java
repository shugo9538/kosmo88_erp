package com.kosmo88.logistics_erp.wms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.InboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_inboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchase_itemDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface InboundDao {

	List<V_purchaseDto> selectList();
//	void insert(V_purchaseDto dto, int maxId);
	List<V_inboundDto> allInboundList();
	List<V_inboundDto> dispatchedInboundList(int warehouseId);
	void insert(V_purchaseDto dto, int inbound_id, int warehouse_id);
	int selectMaxId();
	V_purchaseDto selectOne(int purahcse_id);
	List<V_purchase_itemDto> selectItemList(int purchase_id);
	void updateState(int purchaseId);

}


@Repository
class InboundDaoImpl implements InboundDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<V_purchaseDto> selectList() {

		List<V_purchaseDto> inboundDtoList = sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectList");
		MyLog.logList(inboundDtoList);
		return inboundDtoList;
	}

	@Override
	public List<V_inboundDto> allInboundList() {
		return sqlSession.selectList(Vars.INBOUND_DAO_PATH+".allInboundList");
	}
	
	@Override
	public List<V_inboundDto> dispatchedInboundList(int warehouseId) {
		return sqlSession.selectList(Vars.INBOUND_DAO_PATH+".dispatchedInboundList", warehouseId);
	}

	@Override
	public void insert(V_purchaseDto dto, int inboundId, int warehouseId) {
//	public void insert(V_purchaseDto dto) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("inbound_id", inboundId);
		paramMap.put("warehouse_id", warehouseId);
		paramMap.put("begin_date", dto.getBegin_date());
		paramMap.put("end_date", dto.getEnd_date());
		paramMap.put("client_id", dto.getClient_id());
		
		sqlSession.insert(Vars.INBOUND_DAO_PATH+".insert", paramMap);
	}

	@Override
	public V_purchaseDto selectOne(int purchase_id) {
		V_purchaseDto dto = sqlSession.selectOne(Vars.DAO_PATH + ".InboundDao.selectOne",purchase_id);
		return dto;
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.DAO_PATH + ".InboundDao.selectMaxId");
	}

	@Override
	public List<V_purchase_itemDto> selectItemList(int purchase_id) {
		return sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectItemList", purchase_id);
	}

	@Override
	public void updateState(int purchase_id) {
		sqlSession.update(Vars.DAO_PATH + ".InboundDao.updateState", purchase_id);
	}
	
	
	
}
