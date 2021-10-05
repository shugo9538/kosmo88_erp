package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;

public interface EmployeeService {
    // 인사 카드 관리
    // 인사 카드 목록
    ArrayList<EmployeeDTO> employeeManagement();

    // 인사카드 등록
    void insertEmployee(MultipartHttpServletRequest req, HttpServletResponse res);

    // 인사 상세
    void detailEmployee(ModelAndView mav, String id);
    
    // 부서코드, 직급코드 불러오기
    void selectCode(HttpServletRequest req, HttpServletResponse res);

    // 인사 수정
    void updateEmployee(ModelAndView mav, String id);

}