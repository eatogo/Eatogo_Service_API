package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(StoreAuthorizationPks.class)
@Table(name = "STORE_AUTHORIZATIONS")
public class StoreAuthorization implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "store_auth_id")
	private Integer storeAuthId;
	
	@Id
	@Column(name = "store_auth_user")
	private Integer storeAuthUser;
	
	@Column(name = "store_auth")
	private String storeAuth;
	
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

	public String getStoreAuth() {
		return storeAuth;
	}

	public void setStoreAuth(String storeAuth) {
		this.storeAuth = storeAuth;
	}

}