package com.kosmo88.logistics_erp.wms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;
import com.kosmo88.logistics_erp.wms.dto.V_sales_itemDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface OutboundDao {
	void insert();
	void insert(V_salesDto dto, int outboundId, int warehouseId);
	void updateState(int sales_id);
	List<V_sales_itemDto> selectItemList(int sales_id);
	int selectMaxId();
	V_salesDto selectOne(int sales_id);
	List<V_salesDto> selectSalesList();
	List<V_outboundDto> select();
	List<V_outboundDto> allOutboundList(); 
}





@Repository
class OutboundDaoImpl implements OutboundDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert() {
	}

	@Override
	public void insert(V_salesDto dto, int outboundId, int warehouseId) {
//	public void insert(V_salesDto dto) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("outbound_id", outboundId);
		paramMap.put("warehouse_id", warehouseId);
		paramMap.put("begin_date", dto.getBegin_date());
		paramMap.put("end_date", dto.getEnd_date());
		paramMap.put("client_id", dto.getClient_id());
		//특정 창고에서 V_outbound를 조회하기 위해 warehouseId값이 필요한데, 쿼리 말고 서비스에서 저장해도 좋을듯하다
		//1. warehouse_id를 넣어서 새 테이블생성
		//2. 어차피 다른 정보들이 같으므로 request사용하되 ,warehouse_id 정보 집어넣기
		//2-1. 연결 테이블
		//하나의 요청과 창고는 1대 다 관계이다

		
		sqlSession.insert(Vars.OUTBOUND_DAO_PATH+".insert", paramMap);
	}

	@Override
	public V_salesDto selectOne(int sales_id) {
		V_salesDto dto = sqlSession.selectOne(Vars.DAO_PATH + ".OutboundDao.selectOne",sales_id);
		return dto;
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne(Vars.DAO_PATH + ".OutboundDao.selectMaxId");
	}

	@Override
	public List<V_sales_itemDto> selectItemList(int sales_id) {
		return sqlSession.selectList(Vars.DAO_PATH + ".OutboundDao.selectItemList", sales_id);
	}

	@Override
	public void updateState(int sales_id) {
		sqlSession.update(Vars.DAO_PATH + ".OutboundDao.updateSales", sales_id);
	}

	@Override
	public List<V_outboundDto> select() {
		return null;
	}


	@Override
	public List<V_salesDto> selectSalesList() {
		return null;
	}

	@Override
	public List<V_outboundDto> allOutboundList() {
		return null;
	}
	


}
