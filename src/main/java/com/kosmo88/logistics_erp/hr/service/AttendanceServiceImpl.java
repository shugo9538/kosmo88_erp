package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo88.logistics_erp.hr.dao.AttendanceDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceDAO attendanceDAO;
    
    QueryCode state;

    @Override
    public ArrayList<AttendanceDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        return (ArrayList<AttendanceDTO>) attendanceDAO.selectAttendacne();
    }

    @Override
    public boolean insertAttendance(AttendanceDTO dto) {
        dto.setState("결재중");
        state = QueryCode.UPDATE;
        return state.check(attendanceDAO.insertAttendance(dto));
    }

    @Override
    public void attendanceStatus(HttpServletRequest req, HttpServletResponse res) {

    }

    @Override
    public ArrayList<CommuteDTO> commuteList(HttpServletRequest req, HttpServletResponse res) {
        return (ArrayList<CommuteDTO>) attendanceDAO.commutingRecords();
    }

    @Override
    public boolean insertCommute(CommuteDTO dto) {
        state = QueryCode.UPDATE;
        System.out.println("commute insert service");
        return state.check(attendanceDAO.insertCommute(dto));
    }
}
