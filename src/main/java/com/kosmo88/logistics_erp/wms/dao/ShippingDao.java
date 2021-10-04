package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo88.logistics_erp.wms.dto.ShippingDto;
import com.kosmo88.logistics_erp.wms.util.Vars;

public interface ShippingDao {
	void insert();
	List<ShippingDto> select();
	void selectRack();
	void update(); 
	void delete(); 
}
@Repository
class ShippingDaoImpl implements ShippingDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert() {
	}

	@Override
	public List<ShippingDto> select() {
		return sqlSession.selectList(Vars.SHIPPING_DAO_PATH +".select");
	}

	@Override
	public void selectRack() {
	}

	@Override
	public void update() {
	}

	@Override
	public void delete() {
	}


}
