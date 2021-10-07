package com.kosmo88.logistics_erp.hr.dto;

import org.apache.ibatis.type.Alias;

@Alias("HolidayDTO")
public class HolidayDTO {
    private int id;
    private String kind;
    private int attendance_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

}
