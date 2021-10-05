package com.kosmo88.logistics_erp.wms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface InboundDao {

	List<V_purchaseDto> selectList();
//	void insert(V_inboundDto dto, int maxId, int warehouse_id);
	void insert(V_purchaseDto dto, int maxId);
	int selectMaxId();
	V_purchaseDto selectOne(int inbound_id);

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
//	public void insert(V_inboundDto dto, int maxId, int warehouseId) {
	public void insert(V_purchaseDto dto, int maxId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("dto", dto);
		paramMap.put("maxId", maxId);
//		paramMap.put("warehouseId", warehouseId);
		//특정 창고에서 V_inbound를 조회하기 위해 warehouseId값이 필요한데, 쿼리 말고 서비스에서 저장해도 좋을듯하다
		//1. warehouse_id를 넣어서 새 테이블생성
		//2. 어차피 다른 정보들이 같으므로 request사용하되 ,warehouse_id 정보 집어넣기
		//2-1. 연결 테이블
		//하나의 요청과 창고는 1대 다 관계이다

		
		sqlSession.insert(Vars.INBOUND_DAO_PATH+"insert", dto);
	}

	@Override
	public V_purchaseDto selectOne(int inbound_id) {
		V_purchaseDto dto = sqlSession.selectOne(Vars.DAO_PATH + ".InboundDao.selectOne",inbound_id);
		return dto;
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.DAO_PATH + ".InboundDao.selectOne");
	}
	
	
}
