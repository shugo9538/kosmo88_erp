package com.kosmo88.logistics_erp.hr.dto;

import java.util.Date;

public class AttendanceDTO {
    private int id;
    private Date application_date;
    private Date begin_date;
    private Date end_date;
    private String reason;
    private String state;
    private int attendance_cd_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getApplication_date() {
        return application_date;
    }

    public void setApplication_date(Date application_date) {
        this.application_date = application_date;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAttendance_cd_id() {
        return attendance_cd_id;
    }

    public void setAttendance_cd_id(int attendance_cd_id) {
        this.attendance_cd_id = attendance_cd_id;
    }

}
