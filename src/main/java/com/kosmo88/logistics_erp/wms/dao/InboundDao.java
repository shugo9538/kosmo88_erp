package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.V_InboundDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface InboundDao {
	List<V_InboundDto> selectList();
	

}


@Repository
class InboundDaoImpl implements InboundDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<V_InboundDto> selectList() {

		List<V_InboundDto> inboundDtoList = sqlSession.selectList(Vars.DAO_PATH + ".InboundDao.selectList");
		MyLog.logList(inboundDtoList);
		return inboundDtoList;
	}
	
	
}
