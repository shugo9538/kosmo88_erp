package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;

public interface HolidayService {
    // 휴가
    // 휴가 잔여일수 현황
    ArrayList<HolidayUsageStatusDTO> leftHolidayNum();

    // 휴가 사용실적
    void useHolidayNum(HttpServletRequest req, HttpServletResponse res);

    // 근태 집계표
    void attendanceTable(HttpServletRequest req, HttpServletResponse res);
}
