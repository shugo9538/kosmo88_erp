package com.kosmo88.logistics_erp.hr.dto;

import java.util.Date;

public class PaySlipDTO {
    private int id;
    private String type;
    private Date register_date;
    private Date update_date;
    private char state;
//    private DepartmentDTO departmentDTO;
//    private RequestDTO requestDTO;
//  id  
//  begin_date  
//  end_date    
//  state   
//  employee_id 
//  client_id   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }
//    public DepartmentDTO getDepartment_id() {
//        return department_id;
//    }
//    public void setDepartment_id(DepartmentDTO departmentDTO) {
//        this.departmentDTO = departmentDTO;
//    }
//    public RequestDTO getRequest_id() {
//        return requestDTO;
//    }
//    public void setRequest_id(RequestDTO requestDTO) {
//        this.requestDTO = requestDTO;
//    }
}
