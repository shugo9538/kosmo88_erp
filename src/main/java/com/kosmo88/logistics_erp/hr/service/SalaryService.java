package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

public interface SalaryService {
    // 급여대장
    // 월별 지급 및 현황
    ArrayList<SalaryDTO> monthlyPaymentAndStatus();

    // 급여 통계
    void salaryStatistics(HttpServletRequest req, HttpServletResponse res);

    // 사원 검색
    void selectEmployee(HttpServletRequest req, HttpServletResponse res);
    
    // 근로소득
    void earnedIncome(HttpServletRequest req, HttpServletResponse res);
    
    // 급여 전표
    boolean insertSalaryAction(SalaryDTO dto);
}
