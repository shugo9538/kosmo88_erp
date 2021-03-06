package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.dto.SearchEmployeeDTO;

public interface EmployeeDAO {
    // 인사 카드 관리
    List<EmployeeDTO> employeeList();
    
    // 인사 카드 관리
    List<SearchEmployeeDTO> searchEmployeeList();
    
    // 인사카드 등록
    int insertEmployee(EmployeeDTO dto);

    // 인사 상세
    EmployeeDTO detailEmployee(String id);

    // 인사 수정 등록
    int updateEmployee(EmployeeDTO dto);
}
