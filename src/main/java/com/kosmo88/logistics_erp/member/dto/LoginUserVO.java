package com.kosmo88.logistics_erp.member.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUserVO extends User {
    private static final long serialVersionUID = 1L;
    private String userid;

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