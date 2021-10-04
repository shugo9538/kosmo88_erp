package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;

public interface AttendanceDAO {
    // 근태
    // 근태 목록 수
    int getAttendanceNum();
    
    // 근태 조회
    List<AttendanceDTO> selectAttendacne();

    // 근태 입력
    int insertAttendance(AttendanceDTO dto);

    // 출퇴근 기록부
    List<CommuteDTO> commutingRecords();

    // 출퇴근 입력
    int insertCommute(CommuteDTO dto);
}
