package com.kosmo88.logistics_erp.hr.dao;

import java.util.ArrayList;
import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

// 기초 환경 설정
public interface ConfigurationDAO {
    // 기초 환경 설정
    // 인사 코드 조회
    List<HRCodeDTO> selectHRCode();

    // 부서 코드 조회
    List<DepartmentCodeDTO> selectDepartments();

    // 직급 코드 조회
    List<PositionCodeDTO> selectPosition();

    // 근태 코드 조회
    List<AttendanceCodeDTO> selectAttendanceCode();
    
    //호봉 테이블
    List<PayStepTableDTO> selectAnnualSalary();
}