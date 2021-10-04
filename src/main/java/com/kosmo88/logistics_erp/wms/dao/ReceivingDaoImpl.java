package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.ReceivingDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

@Repository
public class ReceivingDaoImpl implements ReceivingDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert() {
	}

	@Override
	public List<ReceivingDto> select() {
        List<ReceivingDto> list = sqlSession.selectList(Vars.DAO_PATH + ".select");
		return list;
	}

}
