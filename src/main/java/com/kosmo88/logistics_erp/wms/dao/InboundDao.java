package com.kosmo88.logistics_erp.wms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_inboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_inbound_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface InboundDao {
	List<V_purchaseDto> selectList();
	void updateWarehousedDate(int requestId);
	//	void insert(V_purchaseDto dto, int maxId);
	List<V_inboundDto> allInboundList();
	List<V_inboundDto> selectDispatchedInboundList(int warehouseId);
	List<V_inboundDto> selectWarehousedInboundList(int warehouseId);
	List<V_inbound_itemDto> selectWarehousedInboundItemList(int warehouseId);
	void insertInbound(V_purchaseDto dto, int inbound_id, int warehouseId);
	int selectMaxId();
	V_purchaseDto selectOne(int purahcse_id);
	List<V_request_itemDto> selectItemList(int requestId);
	void updateState(int requestId);

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
	public List<V_inboundDto> selectDispatchedInboundList(int warehouseId) {
		return sqlSession.selectList(Vars.INBOUND_DAO_PATH+".selectDispatchedInboundList", warehouseId);
	}

	
	@Override
	public void insertInbound(V_purchaseDto dto, int inboundId, int warehouseId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("inboundId", inboundId);
		paramMap.put("warehouseId", warehouseId);
		paramMap.put("requestId", dto.getRequest_id());
//		paramMap.put("begin_date", dto.getBegin_date());
//		paramMap.put("end_date", dto.getEnd_date());
//		paramMap.put("client_id", dto.getClient_id());
		
		sqlSession.insert(Vars.INBOUND_DAO_PATH+".insertInbound", paramMap);
	}
	

	@Override
	public V_purchaseDto selectOne(int requestId) {
		V_purchaseDto dto = sqlSession.selectOne(Vars.DAO_PATH + ".InboundDao.selectOne", requestId);
		return dto;
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.DAO_PATH + ".InboundDao.selectMaxId");
	}

	@Override
	public List<V_request_itemDto> selectItemList(int requestId) {
		return sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectItemList", requestId);
	}

	@Override
	public void updateState(int requestId) {
		sqlSession.update(Vars.DAO_PATH + ".InboundDao.updateState", requestId);
	}
	

	@Override
	public void updateWarehousedDate(int requestId) {
		sqlSession.update(Vars.DAO_PATH + ".InboundDao.updateWarehousedDate", requestId);
	}


	@Override
	public List<V_inboundDto> selectWarehousedInboundList(int warehouseId) {
		return sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectWarehousedInboundList", warehouseId);
	}

	@Override
	public List<V_inbound_itemDto> selectWarehousedInboundItemList(int warehouseId) {
		return sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectWarehousedInboundItemList", warehouseId);
	}
	
}
