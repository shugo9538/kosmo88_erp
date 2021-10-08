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

import com.kosmo88.logistics_erp.member.dto.LoginUserVO;
import com.kosmo88.logistics_erp.member.dto.UserDTO;

public class AuthenticationHandler implements UserDetailsService {
    @Autowired
    SqlSessionTemplate sqlSession;

    // security-context.xml에서 inject
    public AuthenticationHandler(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserDTO user = sqlSession.selectOne("com.kosmo88.logistics_erp.member.dao.UserDAO.getUserData", id);
        System.out.println(id);
        // 인증 실패시 인위적으로 예외 발생
        if (user == null)
            throw new UsernameNotFoundException(id);

        System.out.println(user.getAuthorities());
        List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
        authority.add(new SimpleGrantedAuthority(user.getAuthorities()));
        System.out.println(authority);

        // enabled updated 예정
        return new LoginUserVO(user.getEmployee_id(), user.getPassword(), true, true,
                true, true, authority, user.getId());
    }

}
