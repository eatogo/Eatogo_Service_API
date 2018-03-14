package edu.ntut.Java007.web.vo;

import java.io.Serializable;

public class StoreInfoPayload implements Serializable {

	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	private Integer storeId;
	
	private String storeName;
	
	private String storeAddress;
	
	private String storePhone;
	
	private String storeEmail;
	
	private String storeOpenHour;
	
	private String storeIntro;
	
	private String storeArea;
	
	private String storeOperateType;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreEmail() {
		return storeEmail;
	}

	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}

	public String getStoreOpenHour() {
		return storeOpenHour;
	}

	public void setStoreOpenHour(String storeOpenHour) {
		this.storeOpenHour = storeOpenHour;
	}

	public String getStoreIntro() {
		return storeIntro;
	}

	public void setStoreIntro(String storeIntro) {
		this.storeIntro = storeIntro;
	}

	public String getStoreArea() {
		return storeArea;
	}

	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}

	public String getStoreOperateType() {
		return storeOperateType;
	}

	public void setStoreOperateType(String storeOperateType) {
		this.storeOperateType = storeOperateType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StoreInfoPayload [")
			.append("storeId=").append(storeId)
			.append(", storeName=").append(storeName)
			.append(", storeAddress=").append(storeAddress)
			.append(", storePhone=").append(storePhone)
			.append(", storeEmail=").append(storeEmail)
			.append(", storeOpenHour=").append(storeOpenHour)
			.append(", storeIntro=").append(storeIntro)
			.append(", storeArea=").append(storeArea)
			.append(", storeOperateType=").append(storeOperateType)
			.append("]");
		return builder.toString();
	}

}