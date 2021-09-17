package com.kosmo88.logistics_erp.member.handler;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kosmo88.logistics_erp.dto.LoginUserVO;
import com.kosmo88.logistics_erp.dto.UserDTO;

public class AuthenticationHandler implements UserDetailsService {
    @Autowired
    SqlSessionTemplate sqlSession;

    // security-context.xml에서 inject
    public AuthenticationHandler(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        UserDTO user = sqlSession.selectOne("com.kosmo88.logistics_erp.account.dao.UserDAO.getUserData", userid);
        System.out.println(userid);
        // 인증 실패시 인위적으로 예외 발생
        if (user == null)
            throw new UsernameNotFoundException(userid);

        System.out.println(user.getAuthority());
        List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
        authority.add(new SimpleGrantedAuthority(user.getAuthority()));
        System.out.println(authority);

        return new LoginUserVO(user.getUsername(), user.getPassword(), true, true,
                true, true, authority, user.getUserid());
    }

}
