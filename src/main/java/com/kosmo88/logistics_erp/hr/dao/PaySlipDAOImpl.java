package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;

@Repository
public class PaySlipDAOImpl implements PaySlipDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.PaySlipDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public int makePaySlip(PaySlipDTO dto) {
        return 0;
    }

    @Override
    public List<PaySlipDTO> totalPaySlip() {
        return sqlSession.selectList(STATEMENT + ".totalPaySlip");
    }
}
