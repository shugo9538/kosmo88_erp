package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;

import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;

public interface SalesItemDAO {

	public List<SalesItemDTO> getItemList(int item_id);
}
