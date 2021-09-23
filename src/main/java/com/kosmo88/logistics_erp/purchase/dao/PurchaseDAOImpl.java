package com.kosmo88.logistics_erp.purchase.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PurchaseDAOImpl implements PurchaseDAO {
    private static final String STATEMENT = "com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO";

    @Autowired
    SqlSession sqlSession;

}
