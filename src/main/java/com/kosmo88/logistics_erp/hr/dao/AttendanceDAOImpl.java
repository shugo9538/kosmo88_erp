package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.HRDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public int insertAttendance(AttendanceDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertAttendance", dto);
    }

    @Override
    public List<AttendanceDTO> selectAttendacne() {
        return sqlSession.selectList(STATEMENT + ".selectAttendacne");
    }

    @Override
    public AttendanceDTO attendanceStatus() {
        return null;
    }

    @Override
    public List<CommuteDTO> commutingRecords() {
        return sqlSession.selectList(STATEMENT + ".commutingRecords");
    }

    @Override
    public int insertCommute(CommuteDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertCommute", dto);
    }
}
