package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.AttendanceDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceDAO attendanceDAO;
    
    QueryCode state;

    @Override
    public ArrayList<AttendanceDTO> selectAttendacne() {
        return (ArrayList<AttendanceDTO>) attendanceDAO.selectAttendacne();
    }

    @Override
    public boolean insertAttendance(AttendanceDTO dto) {
        dto.setState("결재중");
        state = QueryCode.UPDATE;
        return state.check(attendanceDAO.insertAttendance(dto));
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
