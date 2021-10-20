package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;

public interface ConfigurationService {
    // 기초 환경 설정
    // 인사 코드 조회
    ArrayList<HRCodeDTO> selectHRCode();

    // 부서 코드 조회
    ArrayList<DepartmentCodeDTO> selectDepartments();

    // 직급 코드 조회
    ArrayList<PositionCodeDTO> selectPosition();

    // 근태 코드 조회
    ArrayList<AttendanceCodeDTO> selectAttendanceCode();
    
    //호봉 테이블
    ArrayList<PayStepTableDTO> selectAnnualSalary();

    // 인사 코드 등록
    void insertHRCode(HRCodeDTO dto);
//
//    // 사원별 휴가 일수 조회
//    void employeeHasHoliday(HttpServletRequest req, HttpServletResponse res);
//
//    // 급여 관리
//    void manageSalary(HttpServletRequest req, HttpServletResponse res);
//
//    // 호봉 테이블
//    void salayStepTable(HttpServletRequest req, HttpServletResponse res);
}