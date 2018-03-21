package edu.ntut.Java007.web.vo;

import java.io.Serializable;

public class StoreAuthPayload implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	private Integer storeId;
	
	private Integer storeUser;
	
	private String storeUserName;
	
	private String storeUserCellphone;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getStoreUser() {
		return storeUser;
	}

	public void setStoreUser(Integer storeUser) {
		this.storeUser = storeUser;
	}

	public String getStoreUserName() {
		return storeUserName;
	}

	public void setStoreUserName(String storeUserName) {
		this.storeUserName = storeUserName;
	}

	public String getStoreUserCellphone() {
		return storeUserCellphone;
	}

	public void setStoreUserCellphone(String storeUserCellphone) {
		this.storeUserCellphone = storeUserCellphone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StoreAuthPayload [storeId=").append(storeId).append(", storeUser=").append(storeUser)
				.append(", storeUserName=").append(storeUserName).append(", storeUserCellphone=")
				.append(storeUserCellphone).append("]");
		return builder.toString();
	}
	
}