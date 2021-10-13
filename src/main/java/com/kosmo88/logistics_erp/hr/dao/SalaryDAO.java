package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

// 급여대장
public interface SalaryDAO {
    // 월별 지급 및 현황
    List<SalaryDTO> monthlyPaymentAndStatus();

    // 급여 통계
    List<SalaryDTO> salaryStatistics();

    // 근로소득
    int earnedIncome();
    
    int insertSalaryAction(SalaryDTO dto);
}
