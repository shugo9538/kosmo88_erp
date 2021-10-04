package com.kosmo88.logistics_erp.hr.dto;

import java.util.Date;

public class SalaryDTO {
    private int id;
    private int basic_pay;
    private int overtime_pay;
    private int bonus;
    private int meal_fee;
    private int income_tax;
    private Date payday;
    private int employee_salary;
    private String payment_status;
    private String employee_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(int basic_pay) {
        this.basic_pay = basic_pay;
    }

    public int getOvertime_pay() {
        return overtime_pay;
    }

    public void setOvertime_pay(int overtime_pay) {
        this.overtime_pay = overtime_pay;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getMeal_fee() {
        return meal_fee;
    }

    public void setMeal_fee(int meal_fee) {
        this.meal_fee = meal_fee;
    }

    public int getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(int income_tax) {
        this.income_tax = income_tax;
    }

    public Date getPayday() {
        return payday;
    }

    public void setPayday(Date payday) {
        this.payday = payday;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

}
