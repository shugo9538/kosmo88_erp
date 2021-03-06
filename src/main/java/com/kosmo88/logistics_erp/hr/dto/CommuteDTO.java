package com.kosmo88.logistics_erp.hr.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("CommuteDTO")
public class CommuteDTO {
    private int id;
    private Date work_date;
    private String begin_date;
    private String end_date;
    private int night_time;
    private int over_time;
    private int attendance_id;
    private String employee_id;
    private int rnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getWork_date() {
        return work_date;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getNight_time() {
        return night_time;
    }

    public void setNight_time(int night_time) {
        this.night_time = night_time;
    }

    public int getOver_time() {
        return over_time;
    }

    public void setOver_time(int over_time) {
        this.over_time = over_time;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }
}
