package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.InboundDto;
import com.kosmo88.logistics_erp.wms.dto.ReceivingDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface ReceivingDao {

	void insert();
	List<ReceivingDto> select();
	List<InboundDto> inboundList(int warehouseId);
}

@Repository
class ReceivingDaoImpl implements ReceivingDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert() {
	}

	@Override
	public List<ReceivingDto> select() {
        List<ReceivingDto> list = sqlSession.selectList(Vars.RECEIVING_DAO_PATH + ".select");
		return list;
	}

	@Override
	public List<InboundDto> inboundList(int warehouseId) {
		return sqlSession.selectList(Vars.RECEIVING_DAO_PATH+".inboundList", warehouseId);
	}

}
