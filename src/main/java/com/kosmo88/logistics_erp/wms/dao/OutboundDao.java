package com.kosmo88.logistics_erp.wms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface OutboundDao {
	void updateState(int requestId);
	List<V_outboundDto> selectDispatchedOutboundList(int warehouseId);
	List<V_request_itemDto> selectItemList(int requestId);
	int selectMaxId();
	V_salesDto selectOne(int requestId);
	List<V_salesDto> selectSalesList();
	List<V_outboundDto> select();
	List<V_outboundDto> allOutboundList();
	void insertOutbound(V_salesDto dto, int outboundId, int warehouseId);
	List<V_outboundDto> selectShippedOutboundList(int warehouseId); 
}


@Repository
class OutboundDaoImpl implements OutboundDao{

	@Autowired
	SqlSession sqlSession;

	
	@Override
	public void insertOutbound(V_salesDto dto, int outboundId, int warehouseId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("inboundId", outboundId);
		paramMap.put("warehouseId", warehouseId);
		paramMap.put("requestId", dto.getRequest_id());
		
		sqlSession.insert(Vars.OUTBOUND_DAO_PATH+".insertOutbound", paramMap);
	}

	@Override
	public V_salesDto selectOne(int requestId) {
		V_salesDto dto = sqlSession.selectOne(Vars.DAO_PATH + ".OutboundDao.selectOne",requestId);
		return dto;
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.DAO_PATH + ".OutboundDao.selectMaxId");
	}

	@Override
	public List<V_request_itemDto> selectItemList(int requestId) {
		return sqlSession.selectList(Vars.DAO_PATH + ".OutboundDao.selectItemList", requestId);
	}

	@Override
	public void updateState(int requestId) {
		sqlSession.update(Vars.DAO_PATH + ".OutboundDao.updateState", requestId);
	}

	@Override
	public List<V_outboundDto> select() {
		return null;
	}


	@Override
	public List<V_salesDto> selectSalesList() {
		return sqlSession.selectList(Vars.OUTBOUND_DAO_PATH + ".selectSalesList");
	}

	@Override
	public List<V_outboundDto> allOutboundList() {
		return sqlSession.selectList(Vars.OUTBOUND_DAO_PATH+".allOutboundList");
	}


	@Override
	public List<V_outboundDto> selectDispatchedOutboundList(int warehouseId) {
		return sqlSession.selectList(Vars.OUTBOUND_DAO_PATH+".selectDispatchedOutboundList", warehouseId);
	}

	@Override
	public List<V_outboundDto> selectShippedOutboundList(int warehouseId) {
		return sqlSession.selectList(Vars.DAO_PATH + ".OutboundDao.selectShippedOutboundList", warehouseId);
	}
	


}
