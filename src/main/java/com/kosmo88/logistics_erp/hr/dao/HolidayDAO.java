package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;

public interface HolidayDAO {
    // 휴가
    // 휴가 잔여일수 현황
    List<HolidayUsageStatusDTO> leftHolidayNum();
    // 휴가 사용실적
    List<HolidayUsageStatusDTO> useHolidayNum();
    // 근태 집계표
    List<AttendanceDTO> attendanceTable(AttendanceDTO dto);
}
