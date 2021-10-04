package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.SectionDto;

public interface SectionDao {

	void insert(SectionDto sectionDto);
	void select();
	List<SectionDto> selectList(int warehouseId);
	int selectMaxId();
	void update(); 
	void delete(); 
}

@Repository
class SectionDaoImpl implements SectionDao {

	@Autowired
	SqlSession sqlSession;

//	기존에 Dao에서 하던것 : Service로부터 Dto 등을 넘겨받으면서 실행. DB 와 연결하여 결과를 받아와 저장
//	com.kosmo88.logistics_erp.wms.dao.SectionDao.insert
	@Override
	public void insert(SectionDto sectionDto) {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.SectionDao.insert", sectionDto);
	}

	@Override
	public void select() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.SectionDao.select");
	}

	@Override
	public List<SectionDto> selectList(int warehouseId) {
		return sqlSession.selectList("com.kosmo88.logistics_erp.wms.dao.SectionDao.selectList", warehouseId);
	}

	@Override
	public int selectMaxId() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.wms.dao.SectionDao.selectMaxId");
	}
	

	@Override
	public void update() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.SectionDao.insert");
	}

	@Override
	public void delete() {
		sqlSession.insert("com.kosmo88.logistics_erp.wms.dao.SectionDao.insert");
	}



}

