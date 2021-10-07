package com.kosmo88.logistics_erp.hr.dto;

import org.apache.ibatis.type.Alias;

@Alias("PayStepTableDTO")
public class PayStepTableDTO {
    private String position;
    private int salary;
    private int year_step;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYear_step() {
        return year_step;
    }

    public void setYear_step(int year_step) {
        this.year_step = year_step;
    }
}
