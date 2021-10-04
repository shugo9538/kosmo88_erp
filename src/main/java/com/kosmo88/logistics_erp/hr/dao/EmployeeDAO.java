package com.kosmo88.logistics_erp.hr.dao;

import java.util.ArrayList;
import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;

public interface EmployeeDAO {
    // 인사 카드 관리
    List<EmployeeDTO> employeeList();
}
