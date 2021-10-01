package com.kosmo88.logistics_erp.hr.dto;

public class HolidayUsageStatusDTO {
    private String employee_id;
    private int use_date;
    private int annual_holiday;
    private int holiday_id;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getUse_date() {
        return use_date;
    }

    public void setUse_date(int use_date) {
        this.use_date = use_date;
    }

    public int getAnnual_holiday() {
        return annual_holiday;
    }

    public void setAnnual_holiday(int annual_holiday) {
        this.annual_holiday = annual_holiday;
    }

    public int getHoliday_id() {
        return holiday_id;
    }

    public void setHoliday_id(int holiday_id) {
        this.holiday_id = holiday_id;
    }
}
