package com.kosmo88.logistics_erp.wms.dto;

public class ShippingDto {

	private int id;
	private int warehouseId;
	private int destinationId;
	private int itemId;
	private int count;
	private int status;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public int getDepartureId() {
		return destinationId;
	}
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShippingDto [id=" + id + ", warehouseId=" + warehouseId + ", destinationId=" + destinationId + ", itemId="
				+ itemId + ", count=" + count + ", status=" + status + "]";
	}
}
