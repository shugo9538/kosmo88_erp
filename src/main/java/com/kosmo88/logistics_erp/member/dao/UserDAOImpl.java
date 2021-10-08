package com.kosmo88.logistics_erp.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.member.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final String STATEMENT = "com.kosmo88.logistics_erp.member.dao.UserDAO";

    @Autowired
    SqlSession sqlSession;

    @Override
    public UserDTO getUserData(String id) {
        return sqlSession.selectOne(STATEMENT + ".getUserData", id);
    }

    @Override
    public int insertUser(UserDTO vo) {
        return sqlSession.insert(STATEMENT + ".insertUser", vo);
    }
}
