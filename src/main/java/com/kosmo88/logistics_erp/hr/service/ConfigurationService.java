package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ConfigurationService {
    // 기초 환경 설정
    // 근태 항목 목록 조회
    void attendanceCodeManagement(HttpServletRequest req, HttpServletResponse res);

    // 근태 항목 등록
    void insertAttendanceCode(HttpServletRequest req, HttpServletResponse res);

    // 사원별 휴가 일수 조회
    void employeeHasHoliday(HttpServletRequest req, HttpServletResponse res);

    // 급여 관리
    void manageSalary(HttpServletRequest req, HttpServletResponse res);

    // 호봉 테이블
    void salayStepTable(HttpServletRequest req, HttpServletResponse res);
}