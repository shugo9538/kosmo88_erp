package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AttendanceService {
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

    // 근태
    // 근태 조회
    void selectAttendacne(HttpServletRequest req, HttpServletResponse res);

    // 근태 입력
    void insertAttendance(HttpServletRequest req, HttpServletResponse res);

    // 근태 현황
    void attendanceStatus(HttpServletRequest req, HttpServletResponse res);

    // 출퇴근 기록부
    void commutingRecords(HttpServletRequest req, HttpServletResponse res);

    // 휴가
    // 휴가 잔여일수 현황
    void leftHolidayNum(HttpServletRequest req, HttpServletResponse res);

    // 휴가 사용실적
    void useHolidayNum(HttpServletRequest req, HttpServletResponse res);

    // 근태 집계표
    void attendanceTable(HttpServletRequest req, HttpServletResponse res);

    // 급여대장
    // 월별 지급 및 현황
    void monthlyPaymentAndStatus(HttpServletRequest req, HttpServletResponse res);

    // 급여 통계
    void salaryStatistics(HttpServletRequest req, HttpServletResponse res);

    // 근로소득
    void earnedIncome(HttpServletRequest req, HttpServletResponse res);

    // 전표관리
    // 전표 생성
    void makePaySlip(HttpServletRequest req, HttpServletResponse res);

    // 전표 집계
    void totalPaySlip(HttpServletRequest req, HttpServletResponse res);
}
