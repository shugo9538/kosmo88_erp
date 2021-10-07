package com.kosmo88.logistics_erp.member.dto;

import org.apache.ibatis.type.Alias;

@Alias("UserDTO")
public class UserDTO {
    private String id; // 사용자 이메일 = ID
    private String employee_id; // 사용자 이메일 = ID
    private String password; // 비밀번호
    private char enabled; // 인증된 회원인지(사용 가능한 계정인지)
    private String authorities; // 권한(사용자, 관리자) : 기존 boolean => String으로

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getEnabled() {
        return enabled;
    }

    public void setEnabled(char enabled) {
        this.enabled = enabled;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}