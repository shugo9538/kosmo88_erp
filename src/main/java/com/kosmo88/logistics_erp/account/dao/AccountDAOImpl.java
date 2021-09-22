package com.kosmo88.logistics_erp.account.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.account.vo.ClientVO;
import com.kosmo88.logistics_erp.account.vo.SlipVO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// 기초정보관리
	// 거래처 목록건수
	@Override
	public int getClientCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getClientCnt");
	}
	// 거래처 목록조회
	@Override
	public List<ClientVO> selectClient(Map<String, Object> map) {
		return sqlSession.selectList("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectClient", map);
	}
	// 신규 거래처 등록
	@Override
	public int insertClient() {
		return sqlSession.insert("com.kosmo88.logistics_erp.account.dao.AccountDAO.insertClient");
	}
	// 거래처 정보 수정
	@Override
	public int updeateClient(int register_num) {
		return sqlSession.update("com.kosmo88.logistics_erp.account.dao.AccountDAO.updeateClient", register_num);
	}
	// 거래처 목록 삭제
	@Override
	public int deleteClient(int register_num) {
		return sqlSession.delete("com.kosmo88.logistics_erp.account.dao.AccountDAO.deleteClient", register_num);
	}
	
	// 일반전표/장부관리
	// 일반전표 건수
	@Override
	public int getSlipCnt() {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.getSlipCnt");
	}
	// 일반전표 조회
	@Override
	public List<SlipVO> selectSlip(Map<String, Object> map) {
		return sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.AccountDAO.selectSlip", map);
	}

}
