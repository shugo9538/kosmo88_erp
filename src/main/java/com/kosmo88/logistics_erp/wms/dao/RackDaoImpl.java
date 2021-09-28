package com.kosmo88.logistics_erp.wms.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RackDaoImpl implements RackDao {

	@Autowired
	SqlSession sqlSession;

//	기존에 Dao에서 하던것 : Service로부터 Dto 등을 넘겨받으면서 실행. DB 와 연결하여 결과를 받아와 저장
//	com.kosmo88.logistics_erp.wms.dao.RackDao.insert
	@Override
	public void insert() {
		sqlSession.insert("com.kosmo88.logistics.wms.dao.RackDao.insert");
	}

	@Override
	public void select() {
		sqlSession.insert("com.kosmo88.logistics.wms.dao.RackDao.select");
	}

	@Override
	public void selectRack() {
		sqlSession.insert("com.kosmo88.logistics.wms.dao.RackDao");
	}

	@Override
	public void update() {
		sqlSession.insert("com.kosmo88.logistics.wms.dao.RackDao.insert");
	}

	@Override
	public void delete() {
		sqlSession.insert("com.kosmo88.logistics.wms.dao.RackDao.insert");
	}

}
