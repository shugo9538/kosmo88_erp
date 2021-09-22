package com.kosmo88.logistics_erp.hr.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface HRDAO {
    // 기초 환경 설정
    // 근태 항목 등록
    int insertAttendanceCode();
    // 사원별 휴가 일수 조회
    int employeeHasHoliday();
    // 출퇴근 반영 기준
    int standardCommute();
    // 급여 관리
    int manageSalary();
    // 호봉 테이블
    int salayStepTable();
    
    // 근태
    // 근태 입력
    int insertAttendance();
    // 근태 조회
    int selectAttendacne();
    // 근태 현황
    int attendanceStatus();
    // 기록부
    int registerDocument();
    
    // 휴가
    // 휴가 잔여일수 현황
    int leftHolidayNum();
    // 휴가 사용실적
    int useHolidayNum();
    // 근태 집계표
    int attendanceTable();
    
    // 급여대장
    // 월별 지급 및 현황
    int monthlyPaymentAndStatus();
    // 급여 통계
    int salaryStatistics();
    // 근로소득
    int earnedIncome();
    
    // 전표관리
    // 급여 전표
    int paySlip();
    // 전표 집계 및 생성
    int makePaySlipAndTotal();
}
