package com.kosmo88.logistics_erp.account.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.account.dto.SlipDTO;

@Repository
public class SlipDAOImpl implements SlipDAO  {

	private final String STATEMENT = "com.kosmo88.logistics_erp.account.dao.SlipDAO";
	
	@Autowired
	SqlSession sqlSession;
	
	// 일반전표 세부부내역
	@Override
	public List<SlipDTO> selectSlipInfo(int slip_id) {
		 List<SlipDTO> list = sqlSession.selectList(STATEMENT +  ".selectSlipInfo", slip_id);
		 return list;
	}
}
