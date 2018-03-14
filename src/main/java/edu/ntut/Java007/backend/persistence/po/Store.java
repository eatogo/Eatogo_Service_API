package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORES")
public class Store implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Integer storeId;
	
	@Column(name = "store_name")
	private String storeName;
	
	@Column(name = "store_address")
	private String storeAddress;
	
	@Column(name = "store_phone")
	private String storePhone;
	
	@Column(name = "store_email")
	private String storeEmail;
	
	@Column(name = "store_logo")
	private String storeLogo;
	
	@Column(name = "store_open_hour")
	private String storeOpenHour;
	
	@Column(name = "store_intro")
	private String storeIntro;
	
	@Column(name = "store_latitude")
	private Double storeLatitude;
	
	@Column(name = "store_longitude")
	private Double storeLongitude;
	
	@Column(name = "store_area")
	private Integer storeArea;
	
	@Column(name = "store_operate_type")
	private String storeOperateType;
	
	@Column(name = "store_status")
	private String storeStatus;

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

	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
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

	public Double getStoreLatitude() {
		return storeLatitude;
	}

	public void setStoreLatitude(Double storeLatitude) {
		this.storeLatitude = storeLatitude;
	}

	public Double getStoreLongitude() {
		return storeLongitude;
	}

	public void setStoreLongitude(Double storeLongitude) {
		this.storeLongitude = storeLongitude;
	}

	public Integer getStoreArea() {
		return storeArea;
	}

	public void setStoreArea(Integer storeArea) {
		this.storeArea = storeArea;
	}

	public String getStoreOperateType() {
		return storeOperateType;
	}

	public void setStoreOperateType(String storeOperateType) {
		this.storeOperateType = storeOperateType;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}
	
}