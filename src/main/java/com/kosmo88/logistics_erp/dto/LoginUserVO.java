package com.kosmo88.logistics_erp.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

//User 클래스는 스프링 시큐리티에 내장된 추상클래스로서, 사용자 상세정보를 담는 클래스이다.
//User클래스는 추상클래스이므로 상속받아 추상메서드를 오버라이드해서 구현한다.
public class LoginUserVO extends User {
    private static final long serialVersionUID = 1L;
    private String userid;
    private String password;
    private String username;
    private int enabled;
    private String authority;
    
    public LoginUserVO(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
            String userid) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonExpired, authorities);
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserVO [");
        sb.append("userid=").append(userid);
        sb.append("]");
        return sb.toString();
    }
}