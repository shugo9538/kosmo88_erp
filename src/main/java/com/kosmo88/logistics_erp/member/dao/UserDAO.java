package com.kosmo88.logistics_erp.member.dao;

import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.dto.UserDTO;

@Repository
public interface UserDAO {
    // 시큐리티 로그인을 위한 사용자 정보 획득
    public UserDTO getUserData(String userid);
    
    // 사용자 회원가입
    public int insertUser(UserDTO dto);
}