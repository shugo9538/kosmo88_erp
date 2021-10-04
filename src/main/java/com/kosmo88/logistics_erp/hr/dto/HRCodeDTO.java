package com.kosmo88.logistics_erp.hr.dto;

public class HRCodeDTO {
    private int id;
    private String name;
    private int hr_group_id;
    private String hr_group_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHr_group_id() {
        return hr_group_id;
    }

    public void setHr_group_id(int hr_group_id) {
        this.hr_group_id = hr_group_id;
    }

    public String getHr_group_name() {
        return hr_group_name;
    }

    public void setHr_group_name(String hr_group_name) {
        this.hr_group_name = hr_group_name;
    }

}
