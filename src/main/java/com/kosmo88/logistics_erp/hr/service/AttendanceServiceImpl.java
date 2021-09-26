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
import com.kosmo88.logistics_erp.util.ViewPager;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceDAO attendanceDAO;
    
    @Autowired
    ViewPager pager;

    @Override
    public ArrayList<AttendanceDTO> selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        pager.setCnt(attendanceDAO.getAttendanceNum());
        return (ArrayList<AttendanceDTO>) attendanceDAO.selectAttendacne();
    }

    @Override
    public void insertAttendance(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        int attendance_cd_id = Integer.parseInt(req.getParameter("attendance_cd_id"));
        Date application_date = Date.valueOf(req.getParameter("application_date"));
        Date begin_date = Date.valueOf(req.getParameter("begin_date"));
        Date end_date = Date.valueOf(req.getParameter("end_date"));
        String reason = req.getParameter("reason");

        AttendanceDTO dto = new AttendanceDTO();
        dto.setId(id);
        dto.setApplication_date(application_date);
        dto.setBegin_date(begin_date);
        dto.setEnd_date(end_date);
        dto.setReason(reason);
        dto.setState("결재중");
        dto.setAttendance_cd_id(attendance_cd_id);
        attendanceDAO.insertAttendance(dto);
    }

    @Override
    public void attendanceStatus(HttpServletRequest req, HttpServletResponse res) {

    }

    @Override
    public ArrayList<CommuteDTO> commutingRecords(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<CommuteDTO> commuteList = (ArrayList<CommuteDTO>) attendanceDAO.commutingRecords();

        req.setAttribute("commuteList", commuteList);
        
        return (ArrayList<CommuteDTO>) attendanceDAO.commutingRecords();
    }

    @Override
    public void insertCommute(HttpServletRequest req, HttpServletResponse res) {
        Date work_date = Date.valueOf(req.getParameter("work_date"));
        System.out.println(req.getParameter("begin_date"));
        String[] time = req.getParameter("begin_date").split(":");
//        Time begin_date = new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1]), 0);
        time = req.getParameter("end_date").split(":");
//        Time end_date = new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1]), 0);
        int night_time = Integer.parseInt(req.getParameter("night_time"));
        int over_time = Integer.parseInt(req.getParameter("over_time"));
        int attendance_id = Integer.parseInt(req.getParameter("attendance_id"));
        String employee_id = req.getParameter("employee_id");

        CommuteDTO dto = new CommuteDTO();
        dto.setWork_date(work_date);
//        dto.setBegin_date(begin_date);
//        dto.setEnd_date(end_date);
        dto.setNight_time(night_time);
        dto.setOver_time(over_time);
        dto.setAttendance_id(attendance_id);
        dto.setEmployee_id(employee_id);
        attendanceDAO.insertCommute(dto);
    }
}
