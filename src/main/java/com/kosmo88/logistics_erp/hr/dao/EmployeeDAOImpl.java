package com.kosmo88.logistics_erp.hr.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.dto.SearchEmployeeDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.EmployeeDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<EmployeeDTO> employeeList() {
        return sqlSession.selectList(STATEMENT + ".employeeList");
    }

    @Override
    public List<SearchEmployeeDTO> searchEmployeeList() {
        return sqlSession.selectList(STATEMENT + ".searchEmployeeList");
    }

    @Override
    public int insertEmployee(EmployeeDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertEmployee", dto);
    }

    @Override
    public EmployeeDTO detailEmployee(String id) {
        return sqlSession.selectOne(STATEMENT + ".detailEmployee", id);
    }

    @Override
    public int updateEmployee(EmployeeDTO dto) {
        return sqlSession.update(STATEMENT + ".updateEmployee", dto);
    }
    
    
    
}
