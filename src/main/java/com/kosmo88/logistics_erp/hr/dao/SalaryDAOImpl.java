package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Repository
public class SalaryDAOImpl implements SalaryDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.SalaryDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<SalaryDTO> monthlyPaymentAndStatus() {
        return sqlSession.selectList(STATEMENT + ".monthlyPaymentAndStatus");
    }

    @Override
    public List<SalaryDTO> salaryStatistics() {
        return null;
    }

    @Override
    public int earnedIncome() {
        return 0;
    }

    @Override
    public int insertSalaryAction(SalaryDTO dto) {
        System.out.println(dto.getBasic_pay());
        System.out.println(dto.getBonus());
        System.out.println(dto.getEmployee_id());
        System.out.println(dto.getId());
        System.out.println(dto.getIncome_tax());
        System.out.println(dto.getMeal_fee());
        System.out.println(dto.getOvertime_pay());
        System.out.println(dto.getPayment_status());
        System.out.println(dto.getPayday());
        System.out.println(STATEMENT + ".insertSalaryAction");
        return sqlSession.insert(STATEMENT + ".insertSalaryAction", dto);
    }
}
