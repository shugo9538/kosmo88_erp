package com.kosmo88.logistics_erp.member.dto;

import java.util.Collection;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Alias("LoginUserVO")
public class LoginUserVO extends User {
    private static final long serialVersionUID = 1L;
    private String id;

    public LoginUserVO(String employee_id, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
            String id) {
        super(employee_id, password, enabled, accountNonExpired, credentialsNonExpired, accountNonExpired, authorities);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserVO [");
        sb.append("userid=").append(id);
        sb.append("]");
        return sb.toString();
    }
}