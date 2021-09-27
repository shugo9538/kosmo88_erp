package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Repository
public class HRDAOImpl implements HRDAO {
    private final String STATEMENT = "com.kosmo88.logistics_erp.hr.dao.HRDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<AttendanceCodeDTO> attendanceCodeList() {
        return sqlSession.selectList(STATEMENT + ".attendanceCodeList");
    }

    @Override
    public int insertAttendanceCode(AttendanceCodeDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertAttendanceCode", dto);
    }

    @Override
    public HolidayUsageStatusDTO employeeHasHoliday(int employee_id) {
        return null;
    }

    @Override
    public List<SalaryDTO> manageSalary() {
        return null;
    }

    @Override
    public PayStepTableDTO salayStepTable() {
        return null;
    }

    @Override
    public int insertAttendance(AttendanceDTO dto) {
        return sqlSession.insert(STATEMENT + ".insertAttendance", dto);
    }

    @Override
    public List<AttendanceDTO> selectAttendacne() {
        return sqlSession.selectList(STATEMENT + ".selectAttendacne");
    }

    @Override
    public AttendanceDTO attendanceStatus() {
        return null;
    }

    @Override
    public List<CommuteDTO> commutingRecords() {
        return sqlSession.selectList(STATEMENT + ".commutingRecords");
    }

    @Override
    public List<HolidayDTO> leftHolidayNum() {
        return null;
    }

    @Override
    public List<HolidayUsageStatusDTO> useHolidayNum() {
        return sqlSession.selectList(STATEMENT + ".useHolidayNum");
    }

    @Override
    public List<AttendanceDTO> attendanceTable(AttendanceDTO dto) {
        return null;
    }

    @Override
    public List<SalaryDTO> monthlyPaymentAndStatus() {
        return null;
    }

    @Override
    public List<SalaryDTO> salaryStatistics() {
        return null;
    }

    @Override
    public int earnedIncome() {
        return 0;
    }

    @Override
    public int makePaySlip(PaySlipDTO dto) {
        return 0;
    }

    @Override
    public List<PaySlipDTO> totalPaySlip() {
        return null;
    }
}