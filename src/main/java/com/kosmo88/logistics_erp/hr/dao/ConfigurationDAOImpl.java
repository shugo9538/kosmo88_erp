package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Repository
public class ConfigurationDAOImpl implements ConfigurationDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.ConfigurationDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<AttendanceCodeDTO> attendanceCodeList() {
        return sqlSession.selectList(STATEMENT + ".attendanceCodeList");
    }

    @Override
    public int insertAttendanceCode(AttendanceCodeDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertAttendanceCode", dto);
    }

    @Override
    public HolidayUsageStatusDTO employeeHasHoliday(int employee_id) {
        return null;
    }

    @Override
    public List<SalaryDTO> manageSalary() {
        return null;
    }

    @Override
    public PayStepTableDTO salayStepTable() {
        return null;
    }
}
