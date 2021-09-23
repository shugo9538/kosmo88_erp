package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

public interface HRDAO {
    // 기초 환경 설정
    // 근태 항목 조회
    List<AttendanceCodeDTO> attendanceCodeList();
    // 근태 항목 등록
    int insertAttendanceCode(AttendanceCodeDTO dto);
    // 사원별 휴가 일수 조회
    HolidayUsageStatusDTO employeeHasHoliday(int employee_id);
    // 급여 관리
    List<SalaryDTO> manageSalary();
    // 호봉 테이블
    PayStepTableDTO salayStepTable();
    
    // 근태
    // 근태 조회
    List<AttendanceDTO> selectAttendacne();
    // 근태 입력
    int insertAttendance(AttendanceDTO dto);
    // 근태 현황
    AttendanceDTO attendanceStatus();
    // 출퇴근 기록부
    List<CommuteDTO> commutingRecords();
    
    // 휴가
    // 휴가 잔여일수 현황 ==> 수정 필요
    List<HolidayDTO> leftHolidayNum();
    // 휴가 사용실적
    List<HolidayUsageStatusDTO> useHolidayNum();
    // 근태 집계표
    List<AttendanceDTO> attendanceTable(AttendanceDTO dto);
    
    // 급여대장
    // 월별 지급 및 현황
    List<SalaryDTO> monthlyPaymentAndStatus();
    // 급여 통계
    List<SalaryDTO> salaryStatistics();
    // 근로소득
    int earnedIncome();
    
    // 전표관리
    // 전표 생성
    int makePaySlip(PaySlipDTO dto);
    // 전표 집계
    List<PaySlipDTO> totalPaySlip();
}
