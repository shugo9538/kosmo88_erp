package com.kosmo88.logistics_erp.hr.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("PaySlipDTO")
public class PaySlipDTO {
    private int id;
    private Date begin_date;
    private Date end_date;
    private String state;
    private int salary_id;
    private int sum_pay;
    private int income_tax;
    private String employee_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(int salary_id) {
        this.salary_id = salary_id;
    }

    public int getSum_pay() {
        return sum_pay;
    }

    public void setSum_pay(int sum_pay) {
        this.sum_pay = sum_pay;
    }

    public int getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(int income_tax) {
        this.income_tax = income_tax;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
