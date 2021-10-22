package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;

@Repository
public class ConfigurationDAOImpl implements ConfigurationDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.ConfigurationDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<HRCodeDTO> selectHRCode() {
        return sqlSession.selectList(STATEMENT + ".selectHRCode");
    }

    @Override
    public List<DepartmentCodeDTO> selectDepartments() {
        return sqlSession.selectList(STATEMENT + ".selectDepartments");
    }

    @Override
    public List<PositionCodeDTO> selectPosition() {
        return sqlSession.selectList(STATEMENT + ".selectPosition");
    }

    @Override
    public List<AttendanceCodeDTO> selectAttendanceCode() {
        return sqlSession.selectList(STATEMENT + ".selectAttendanceCode");
    }

    @Override
    public List<PayStepTableDTO> selectAnnualSalary() {
        return sqlSession.selectList(STATEMENT + ".selectAnnualSalary");
    }

    @Override
    public int insertHRCode(HRCodeDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertHRCode");
    }

}
