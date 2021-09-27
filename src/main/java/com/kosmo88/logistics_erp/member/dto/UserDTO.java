package com.kosmo88.logistics_erp.member.dto;

//User 클래스는 스프링 시큐리티에 내장된 추상클래스로서, 사용자 상세정보를 담는 클래스이다.
//User클래스는 추상클래스이므로 상속받아 추상메서드를 오버라이드해서 구현한다.
public class UserDTO {
    private String userid; // 사용자 이메일 = ID
    private String password; // 비밀번호
    private String username; // 이름
    private String tel; // 전화번호(휴대폰 번호)
    private String advAlert; // 광고 수신 설정 : 기존 boolean => String으로
    private int enabled; // 인증된 회원인지(사용 가능한 계정인지)
    private String authority; // 권한(사용자, 관리자) : 기존 boolean => String으로
    private String key; // 이메일 인증 키

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAdvAlert() {
        return advAlert;
    }

    public void setAdvAlert(String advAlert) {
        this.advAlert = advAlert;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserDTO {");
        sb.append("userid=").append(userid);
        sb.append("password=").append(password);
        sb.append("username=").append(username);
        sb.append("tel=").append(tel);
        sb.append("enabled=").append(enabled);
        sb.append("}");
        return sb.toString();
    }
}