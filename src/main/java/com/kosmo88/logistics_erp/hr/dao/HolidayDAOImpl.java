package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;

@Repository
public class HolidayDAOImpl implements HolidayDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.HolidayDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<HolidayDTO> leftHolidayNum() {
        return null;
    }

    @Override
    public List<HolidayUsageStatusDTO> useHolidayNum() {
        return sqlSession.selectList(STATEMENT + ".useHolidayNum");
    }

    @Override
    public List<AttendanceDTO> attendanceTable(AttendanceDTO dto) {
        return null;
    }
}
