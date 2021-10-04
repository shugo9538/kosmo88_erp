package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SalaryService {
    // 급여대장
    // 월별 지급 및 현황
    void monthlyPaymentAndStatus(HttpServletRequest req, HttpServletResponse res);

    // 급여 통계
    void salaryStatistics(HttpServletRequest req, HttpServletResponse res);

    // 근로소득
    void earnedIncome(HttpServletRequest req, HttpServletResponse res);
}
