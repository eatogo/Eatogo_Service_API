package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;

public class StoreAuthorizationPks implements Serializable {

	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;
	
	private Integer storeAuthId;
	
	private Integer storeAuthUser;

	public Integer getStoreAuthId() {
		return storeAuthId;
	}

	public void setStoreAuthId(Integer storeAuthId) {
		this.storeAuthId = storeAuthId;
	}

	public Integer getStoreAuthUser() {
		return storeAuthUser;
	}

	public void setStoreAuthUser(Integer storeAuthUser) {
		this.storeAuthUser = storeAuthUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storeAuthId == null) ? 0 : storeAuthId.hashCode());
		result = prime * result + ((storeAuthUser == null) ? 0 : storeAuthUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreAuthorizationPks other = (StoreAuthorizationPks) obj;
		if (storeAuthId == null) {
			if (other.storeAuthId != null)
				return false;
		} else if (!storeAuthId.equals(other.storeAuthId))
			return false;
		if (storeAuthUser == null) {
			if (other.storeAuthUser != null)
				return false;
		} else if (!storeAuthUser.equals(other.storeAuthUser))
			return false;
		return true;
	}
	
}