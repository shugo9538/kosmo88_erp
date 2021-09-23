package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

// 기초 환경 설정
public interface ConfigurationDAO {
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
}
