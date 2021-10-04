package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;

public interface AttendanceService {
    // 근태
    // 근태 조회
    ArrayList<AttendanceDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res);

    // 근태 입력
    boolean insertAttendance(AttendanceDTO dto);

    // 근태 현황
    void attendanceStatus(HttpServletRequest req, HttpServletResponse res);

    // 출퇴근 기록부
    ArrayList<CommuteDTO> commuteList(HttpServletRequest req, HttpServletResponse res);
    
    // 출퇴근 입력
    boolean insertCommute(CommuteDTO dto);
}
