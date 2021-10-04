package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.AttendanceDAO";

    @Autowired
    SqlSession sqlSession;
    
    @Override
    public int getAttendanceNum() {
        return sqlSession.selectOne(STATEMENT + ".getAttendanceNum");
    }

    @Override
    public int insertAttendance(AttendanceDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertAttendance", dto);
    }

    @Override
    public List<AttendanceDTO> selectAttendacne() {
        List<AttendanceDTO> list = sqlSession.selectList(STATEMENT + ".selectAttendacne");
        return list;
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
        System.out.println("commute insert");
        return sqlSession.insert(STATEMENT + ".insertCommute", dto);
    }
}
