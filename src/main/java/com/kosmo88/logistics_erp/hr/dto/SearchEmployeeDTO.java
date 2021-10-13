package com.kosmo88.logistics_erp.hr.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("SearchEmployeeDTO")
public class SearchEmployeeDTO {
    private String id;
    private String name;
    private String phone;
    private String email;
    private int department_id;
    private String department_name;
    private int position_id;
    private String position_name;
    private int annual_income;
    private int basic_pay;
    private int time_pay;
    private int over_time;
    private int overtime_pay;
    private int night_time;
    private int work_day;
    private char enabled;

    public int getOvertime_pay() {
        return overtime_pay;
    }

    public void setOvertime_pay(int overtime_pay) {
        this.overtime_pay = overtime_pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public int getAnnual_income() {
        return annual_income;
    }

    public void setAnnual_income(int annual_income) {
        this.annual_income = annual_income;
    }

    public int getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(int basic_pay) {
        this.basic_pay = basic_pay;
    }

    public int getTime_pay() {
        return time_pay;
    }

    public void setTime_pay(int time_pay) {
        this.time_pay = time_pay;
    }

    public int getOver_time() {
        return over_time;
    }

    public void setOver_time(int over_time) {
        this.over_time = over_time;
    }

    public int getNight_time() {
        return night_time;
    }

    public void setNight_time(int night_time) {
        this.night_time = night_time;
    }

    public int getWork_day() {
        return work_day;
    }

    public void setWork_day(int work_day) {
        this.work_day = work_day;
    }

    public char getEnabled() {
        return enabled;
    }

    public void setEnabled(char enabled) {
        this.enabled = enabled;
    }

}
