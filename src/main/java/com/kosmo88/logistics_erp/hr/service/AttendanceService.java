package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AttendanceService {
    // 근태
    // 근태 조회
    void selectAttendacne(HttpServletRequest req, HttpServletResponse res);

    // 근태 입력
    void insertAttendance(HttpServletRequest req, HttpServletResponse res);

    // 근태 현황
    void attendanceStatus(HttpServletRequest req, HttpServletResponse res);

    // 출퇴근 기록부
    void commutingRecords(HttpServletRequest req, HttpServletResponse res);
    
    // 출퇴근 입력
    void insertCommute(HttpServletRequest req, HttpServletResponse res);
}
