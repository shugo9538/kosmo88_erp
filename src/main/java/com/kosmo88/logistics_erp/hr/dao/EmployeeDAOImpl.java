package com.kosmo88.logistics_erp.hr.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.EmployeeDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<EmployeeDTO> employeeList() {
        return sqlSession.selectList(STATEMENT + ".employeeList");
    }

    
}
