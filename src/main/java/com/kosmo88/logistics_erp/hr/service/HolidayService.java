package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HolidayService {
    // 휴가
    // 휴가 잔여일수 현황
    void leftHolidayNum(HttpServletRequest req, HttpServletResponse res);

    // 휴가 사용실적
    void useHolidayNum(HttpServletRequest req, HttpServletResponse res);

    // 근태 집계표
    void attendanceTable(HttpServletRequest req, HttpServletResponse res);
}
