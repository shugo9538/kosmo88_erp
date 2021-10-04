package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;

public interface EmployeeService {
    // 인사 카드 관리
    // 인사 카드 목록
    ArrayList<EmployeeDTO> employeeManagement();

    // 부서 코드 조회
    ArrayList<DepartmentCodeDTO> departmentCodeManagement();

    // 직급 코드 조회
    ArrayList<PositionCodeDTO> positionCodeManagement();

    // 근태 코드 조회
    ArrayList<AttendanceCodeDTO> attendanceCodeManagement();

    void hrCodeManagement(HttpServletRequest req, HttpServletResponse res);
    
    // 근태 항목 등록
    void insertAttendanceCode(HttpServletRequest req, HttpServletResponse res);

    // 사원별 휴가 일수 조회
    void employeeHasHoliday(HttpServletRequest req, HttpServletResponse res);

    // 급여 관리
    void manageSalary(HttpServletRequest req, HttpServletResponse res);

    // 호봉 테이블
    void salayStepTable(HttpServletRequest req, HttpServletResponse res);
}