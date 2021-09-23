package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.HRDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Service
public class HRServiceImpl implements HRService {

    @Autowired
    HRDAO hrDAO;

    @Override
    public void attendanceCodeManagement(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<AttendanceCodeDTO> attendanceCodeList = (ArrayList<AttendanceCodeDTO>) hrDAO.attendanceCodeList();

        req.setAttribute("acList", attendanceCodeList);
    }

    @Override
    public void insertAttendanceCode(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String enabled = req.getParameter("enabled");

        AttendanceCodeDTO dto = new AttendanceCodeDTO(id, name, type, enabled.charAt(0));

        hrDAO.insertAttendanceCode(dto);
    }

    @Override
    public void employeeHasHoliday(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void selectAttendacne(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<AttendanceDTO> attendanceList = (ArrayList<AttendanceDTO>) hrDAO.selectAttendacne();

        req.setAttribute("attendanceList", attendanceList);
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
        hrDAO.insertAttendance(dto);
    }

    @Override
    public void attendanceStatus(HttpServletRequest req, HttpServletResponse res) {

    }

    @Override
    public void commutingRecords(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<CommuteDTO> commuteList = (ArrayList<CommuteDTO>) hrDAO.commutingRecords();

        req.setAttribute("commuteList", commuteList);
    }

    @Override
    public void manageSalary(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void salayStepTable(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void leftHolidayNum(HttpServletRequest req, HttpServletResponse res) {
         ArrayList<HolidayUsageStatusDTO> holidayUsageList = (ArrayList<HolidayUsageStatusDTO>) hrDAO.useHolidayNum();
         
         req.setAttribute("holidayUsageList", holidayUsageList);
    }

    @Override
    public void useHolidayNum(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void attendanceTable(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void monthlyPaymentAndStatus(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void salaryStatistics(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void earnedIncome(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void makePaySlip(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void totalPaySlip(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }
}
