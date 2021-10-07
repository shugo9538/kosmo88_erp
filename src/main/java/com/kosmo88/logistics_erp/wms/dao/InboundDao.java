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
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;
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
	List<V_request_itemDto> selectItemList(int purchase_id);
	void disablePurchase(int purchaseId);

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
		//특정 창고에서 V_inbound를 조회하기 위해 warehouseId값이 필요한데, 쿼리 말고 서비스에서 저장해도 좋을듯하다
		//1. warehouse_id를 넣어서 새 테이블생성
		//2. 어차피 다른 정보들이 같으므로 request사용하되 ,warehouse_id 정보 집어넣기
		//2-1. 연결 테이블
		//하나의 요청과 창고는 1대 다 관계이다

		
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
	public List<V_request_itemDto> selectItemList(int purchase_id) {
		return sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectItemList", purchase_id);
	}

	@Override
	public void disablePurchase(int purchase_id) {
		sqlSession.update(Vars.DAO_PATH + ".InboundDao.disablePurchase", purchase_id);
	}
	
	
	
}
