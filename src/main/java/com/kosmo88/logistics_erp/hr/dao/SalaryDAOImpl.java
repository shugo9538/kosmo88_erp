package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Repository
public class SalaryDAOImpl implements SalaryDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.HRDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<SalaryDTO> monthlyPaymentAndStatus() {
        return null;
    }

    @Override
    public List<SalaryDTO> salaryStatistics() {
        return null;
    }

    @Override
    public int earnedIncome() {
        return 0;
    }
}
